package ru.plumsoftware.movie_search.ui.screens.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import ru.plumsoftware.data.model.ui.Movie

class HomeViewModel : ViewModel() {
    val state = MutableStateFlow(HomeModel())

    fun loadMovie(list: List<Movie>) {
        state.update {
            it.copy(movieList = list)
        }
    }
}