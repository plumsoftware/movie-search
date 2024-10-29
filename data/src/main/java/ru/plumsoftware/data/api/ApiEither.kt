package ru.plumsoftware.data.api

sealed class ApiEither<out D> {
    data object Loading : ApiEither<Nothing>()
    data class Error(val throwable: Throwable) : ApiEither<Nothing>()
    data class Success<D>(val data: D) : ApiEither<D>()
}