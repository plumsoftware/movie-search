package ru.plumsoftware.movie_search.ui.screens.home

import ru.plumsoftware.data.api.ApiEither
import ru.plumsoftware.data.model.ui.Movie

data class HomeModel(
    val selectedMovie: Movie = Movie.empty(),
    val apiEither: ApiEither<List<Movie>> = ApiEither.Loading,
    val genre: String = ""
)
