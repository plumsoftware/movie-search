package ru.plumsoftware.movie_search.mock

import ru.plumsoftware.data.model.ui.Movie


internal fun getMockMovieList(): List<Movie> {
    val movieMockList = mutableListOf<Movie>()
    repeat(20) {
        movieMockList.add(
            Movie(
                preview = null,
                name = "Some name",
                description = "Some description",
                localizedName = "Some localized name",
                year = 2024,
                rating = 5.5f,
                genres = arrayOf("Some genre")
            )
        )
    }
    return movieMockList
}