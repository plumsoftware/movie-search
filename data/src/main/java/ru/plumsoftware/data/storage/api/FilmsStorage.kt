package ru.plumsoftware.data.storage.api

import ru.plumsoftware.data.usecase.api.GetFilmsUseCase

class FilmsStorage(private val getFilmsUseCase: GetFilmsUseCase) {
    suspend fun getMovie() = getFilmsUseCase()
}