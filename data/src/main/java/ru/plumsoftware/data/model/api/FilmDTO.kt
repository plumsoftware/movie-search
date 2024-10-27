package ru.plumsoftware.data.model.api

import com.squareup.moshi.Json

class FilmDTO {
    @Json(name = "id")
    var id: Int? = null

    @Json(name = "localized_name")
    var localizedName: String? = null

    @Json(name = "name")
    var name: String? = null

    @Json(name = "year")
    var year: Int? = null

    @Json(name = "rating")
    var rating: Double? = null

    @Json(name = "image_url")
    var imageUrl: String? = null

    @Json(name = "description")
    var description: String? = null

    @Json(name = "genres")
    var genres: List<String>? = null
}