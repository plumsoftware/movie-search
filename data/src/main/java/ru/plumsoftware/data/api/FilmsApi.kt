package ru.plumsoftware.data.api

import androidx.annotation.Keep
import retrofit2.http.GET
import ru.plumsoftware.data.model.api.FilmsDTO

@Keep
fun interface FilmsApi {
    @GET("/sequeniatesttask/films.json")
    suspend fun getFilms() : FilmsDTO
}