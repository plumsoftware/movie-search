package ru.plumsoftware.movie_search.mock

import ru.plumsoftware.movie_search.ui.model.Movie


internal fun getMockMovieList(): List<Movie> {
    val movieMockList = mutableListOf<Movie>()
    repeat(20) {
        movieMockList.add(
            Movie(
                preview = null,
                name = "Some name",
                description = "Some description",
                localizedName = "Some localized name",
                genres = arrayOf("Some genre")
            )
        )
    }
    return movieMockList
}