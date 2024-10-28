package ru.plumsoftware.movie_search.ui.screens.about

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.plumsoftware.data.model.ui.Movie
import ru.plumsoftware.movie_search.ui.theme.MovieSearchTheme

class AboutMovieFragment : Fragment() {

    private val aboutMovieViewModel by viewModel<AboutMovieViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MovieSearchTheme {

                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val movie = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelable("movie", Movie::class.java) ?: Movie.empty()
        } else {
            arguments?.getParcelable("movie") ?: Movie.empty()
        }
        aboutMovieViewModel.setMovie(movie)
    }
}