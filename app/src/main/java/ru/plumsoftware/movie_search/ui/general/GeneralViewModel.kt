package ru.plumsoftware.movie_search.ui.general

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

class GeneralViewModel(private val filmsStorage: FilmsStorage) : ViewModel() {
    val state = MutableStateFlow(GeneralModel())

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
}