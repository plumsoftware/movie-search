package ru.plumsoftware.movie_search.ui.screens.home

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.plumsoftware.data.api.ApiEither
import ru.plumsoftware.data.model.ui.Movie
import ru.plumsoftware.data.storage.api.FilmsStorage
import ru.plumsoftware.movie_search.R
import ru.plumsoftware.movie_search.utils.isInternetAvailable

class HomeViewModel(
    private val filmsStorage: FilmsStorage,
    @SuppressLint("StaticFieldLeak") private val context: Context
) :
    ViewModel() {
    val state = MutableStateFlow(HomeModel())

    private val superVisorIoCoroutineContext = SupervisorJob() + Dispatchers.IO

    fun loadFilms() {
        viewModelScope.launch(superVisorIoCoroutineContext) {
            state.update {
                it.copy(apiEither = ApiEither.Loading)
            }
            if (isInternetAvailable(context)) {
                val apiEither = filmsStorage.getMovie()
                withContext(Dispatchers.Main) {
                    state.update {
                        it.copy(apiEither = apiEither)
                    }
                }
            } else {
                withContext(Dispatchers.Main) {
                    state.update {
                        it.copy(
                            apiEither = ApiEither.Error(
                                throwable = Throwable(
                                    context.getString(
                                        R.string.no_internet_error
                                    )
                                )
                            )
                        )
                    }
                }
            }
        }
    }

    fun selectMovie(movie: Movie): Bundle {
        state.update {
            it.copy(selectedMovie = movie)
        }
        val bundle = Bundle().apply {
            putParcelable("movie", movie)
        }
        return bundle
    }

    fun selectGenre(genre: String) {
        state.update {
            it.copy(genre = genre)
        }
    }

    fun filterList(list: List<Movie>): List<Movie> {
        val selectedGenre = state.value.genre.lowercase()
        return if (selectedGenre.isEmpty()) {
            list
        } else {
            list.filter { movie ->
                movie.genres.any { genre -> genre in selectedGenre }
            }
        }
    }

    fun launchErrorSnack(throwable: Throwable, snackbarHostState: SnackbarHostState) {
        viewModelScope.launch {
            val result = snackbarHostState
                .showSnackbar(
                    message = throwable.message ?: "",
                    actionLabel = context.getString(R.string.no_internet_error_action),
                    duration = SnackbarDuration.Indefinite
                )
            when (result) {
                SnackbarResult.ActionPerformed -> {
                    loadFilms()
                }
                SnackbarResult.Dismissed -> {}
            }
        }
    }

    fun setMovieList(list: List<Movie>) {
        state.update {
            it.copy(apiEither = ApiEither.Success(data = list))
        }
    }
}