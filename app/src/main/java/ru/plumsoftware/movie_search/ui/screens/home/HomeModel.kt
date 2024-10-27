package ru.plumsoftware.movie_search.ui.screens.home

import ru.plumsoftware.data.model.ui.Movie

data class HomeModel(
    val movieList: List<Movie> = emptyList()
)
