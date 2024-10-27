package ru.plumsoftware.movie_search

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.plumsoftware.movie_search.di.viewModelModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(viewModelModule)
            androidContext(this@App)
        }
    }
}