package ru.plumsoftware.data.usecase.api

import ru.plumsoftware.data.api.FilmsApi
import ru.plumsoftware.data.model.ui.Movie

class GetFilmsUseCase(private val filmsApi: FilmsApi) {
    suspend operator fun invoke() : List<Movie> {
        return filmsApi.getFilms().films.map {
            Movie(
                preview = it.imageUrl,
                name = it.name ?: "",
                description = it.description ?: "",
                localizedName = it.localizedName ?: "",
                genres = it.genres?.toTypedArray() ?: emptyArray<String>()
            )
        }
    }
}