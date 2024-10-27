package ru.plumsoftware.data.model.api

import com.squareup.moshi.Json

data class FilmsDTO(
    @Json(name = "films")
    val films: List<FilmDTO>
)
