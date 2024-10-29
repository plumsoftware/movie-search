package ru.plumsoftware.data.api

import kotlinx.coroutines.runBlocking
import org.junit.Test
import ru.plumsoftware.data.storage.api.FilmsStorage
import ru.plumsoftware.data.usecase.api.GetFilmsUseCase
import org.junit.Assert.*
import ru.plumsoftware.data.model.ui.Movie

class FilmsStorageTest {

    @Test
    fun testFilmsStorage() {
        val filmsApi: FilmsApi = retrofitEngine()
        val filmsStorage = FilmsStorage(
            getFilmsUseCase = GetFilmsUseCase(filmsApi = filmsApi)
        )
        runBlocking {
            when(val apiEither = filmsStorage.getMovie()) {
                is ApiEither.Error -> {
                    assertFalse(true)
                }
                ApiEither.Loading -> {

                }
                is ApiEither.Success -> {
                    val movies: List<Movie> = apiEither.data
                    assertEquals(17, movies.size)

                    assertEquals(null, movies.last().preview)

                    assertEquals("The Shawshank Redemption", movies.first().name)
                    assertEquals(1, movies.first().genres.size)
                }
            }
        }
    }
}