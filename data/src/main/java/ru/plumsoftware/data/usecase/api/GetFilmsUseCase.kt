package ru.plumsoftware.data.usecase.api

import ru.plumsoftware.data.api.ApiEither
import ru.plumsoftware.data.api.FilmsApi
import ru.plumsoftware.data.model.ui.Movie

class GetFilmsUseCase(private val filmsApi: FilmsApi) {
    suspend operator fun invoke() : ApiEither<List<Movie>> {
        val films = filmsApi.getFilms().films

        return if (films.isEmpty()) {
            ApiEither.Error(Throwable(message = "Api error"))
        } else {
            val data = films.map {
                Movie(
                    preview = it.imageUrl,
                    name = it.name ?: "",
                    description = it.description ?: "",
                    localizedName = it.localizedName ?: "",
                    genres = it.genres?.toTypedArray() ?: emptyArray<String>()
                )
            }
            ApiEither.Success(data = data)
        }
    }
}