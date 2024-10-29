package ru.plumsoftware.movie_search.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.plumsoftware.data.api.FilmsApi
import ru.plumsoftware.data.api.retrofitEngine
import ru.plumsoftware.data.storage.api.FilmsStorage
import ru.plumsoftware.data.usecase.api.GetFilmsUseCase

val apiModule = module {
    single { retrofitEngine() }.bind<FilmsApi>()

    singleOf(::GetFilmsUseCase)
    singleOf(::FilmsStorage)
}