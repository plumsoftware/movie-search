package ru.plumsoftware.movie_search.ui.screens.home

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.core.bundle.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import org.koin.androidx.compose.koinViewModel
import ru.plumsoftware.data.api.ApiEither
import ru.plumsoftware.movie_search.R
import ru.plumsoftware.movie_search.ui.components.genre.GenresList
import ru.plumsoftware.movie_search.ui.components.movie.MovieList
import ru.plumsoftware.movie_search.ui.theme.MovieSearchTheme


class HomeScreenFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MovieSearchTheme {
                    HomeScreenContent(activity = requireActivity())
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun HomeScreenContent(activity: Activity) {
    val homeViewModel: HomeViewModel = koinViewModel()
    val state = homeViewModel.state.collectAsState()
    val navController = Navigation.findNavController(activity, R.id.nav_host_fragment)

    LaunchedEffect(Unit) {
        homeViewModel.loadFilms()
    }

    Scaffold {
        when (val apiEither = state.value.apiEither) {
            is ApiEither.Error -> {

            }

            ApiEither.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
                }
            }

            is ApiEither.Success -> {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    item {
                        GenresList(
                            onGenreClick = {
                                homeViewModel.selectGenre(it)
                            }
                        )
                    }
                    item {
                        MovieList(
                            movieList = homeViewModel.filterList(apiEither.data),
                            onMovieClick = {
                                homeViewModel.selectMovie(movie = it)
                            }
                        )
                    }
                }
            }
        }
    }
}