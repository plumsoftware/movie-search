package ru.plumsoftware.movie_search

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.android.test.verify.verify
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.context.unloadKoinModules
import org.koin.test.KoinTest
import ru.plumsoftware.movie_search.di.apiModule
import ru.plumsoftware.movie_search.di.viewModelModule

class TestKoin : KoinTest {

    @Before
    fun start() {
        stopKoin()
        startKoin {
            modules(apiModule, viewModelModule)
        }
    }

    @After
    fun shutDown() {
        unloadKoinModules(listOf(apiModule, viewModelModule))
        stopKoin()
    }

    @OptIn(KoinExperimentalAPI::class)
    @Test
    fun checkStorageModule() {
        apiModule.verify()
    }
}