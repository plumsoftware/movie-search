package ru.plumsoftware.movie_search.ui.general

import ru.plumsoftware.data.api.ApiEither
import ru.plumsoftware.data.model.ui.Movie

data class GeneralModel(
    val selectedMovie: Movie = Movie.empty(),
    val apiEither: ApiEither<List<Movie>> = ApiEither.Loading
)
