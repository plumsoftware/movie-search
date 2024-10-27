package ru.plumsoftware.movie_search.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.plumsoftware.movie_search.ui.screens.home.HomeViewModel

val viewModelModule = module {
    viewModelOf(::HomeViewModel)
}