package ru.plumsoftware.movie_search.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.plumsoftware.data.model.ui.Movie
import ru.plumsoftware.data.storage.api.FilmsStorage

class HomeViewModel(private val filmsStorage: FilmsStorage) : ViewModel() {
    val state = MutableStateFlow(HomeModel())

    private val superVisorIoCoroutineContext = SupervisorJob() + Dispatchers.IO

    fun loadFilms() {
        viewModelScope.launch(superVisorIoCoroutineContext) {
            val apiEither = filmsStorage.getMovie()
            withContext(Dispatchers.Main) {
                state.update {
                    it.copy(apiEither = apiEither)
                }
            }
        }
    }

    fun selectMovie(movie: Movie) {
        state.update {
            it.copy(selectedMovie = movie)
        }
    }

    fun selectGenre(genre: String) {
        state.update {
            it.copy(genre = genre)
        }
    }

    fun filterList(list: List<Movie>): List<Movie> {
        val selectedGenre = state.value.genre.lowercase()
        return if (selectedGenre.isEmpty()) {
            list
        } else {
            list.filter { movie ->
                movie.genres.any { genre -> genre in selectedGenre }
            }
        }
    }
}