package ru.plumsoftware.movie_search.ui.screens.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.core.bundle.Bundle
import androidx.fragment.app.Fragment
import org.koin.androidx.compose.koinViewModel
import ru.plumsoftware.movie_search.ui.theme.MovieSearchTheme


class HomeScreenFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MovieSearchTheme {
                    HomeScreenContent()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun HomeScreenContent() {
    val homeViewModel: HomeViewModel = koinViewModel()
    val state = homeViewModel.state.collectAsState()

    Scaffold {

    }
}