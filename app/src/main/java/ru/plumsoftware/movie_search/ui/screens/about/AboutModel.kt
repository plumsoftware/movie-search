package ru.plumsoftware.movie_search.ui.screens.about

import ru.plumsoftware.data.model.ui.Movie

data class AboutModel(
    val selectedMovie: Movie = Movie.empty()
)
