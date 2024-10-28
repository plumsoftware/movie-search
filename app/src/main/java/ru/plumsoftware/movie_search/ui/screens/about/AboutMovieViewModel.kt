package ru.plumsoftware.movie_search.ui.screens.about

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import ru.plumsoftware.data.model.ui.Movie

class AboutMovieViewModel : ViewModel() {
    val state = MutableStateFlow(AboutModel())

    fun setMovie(movie: Movie) {
        state.update {
            it.copy(selectedMovie = movie)
        }
    }
}