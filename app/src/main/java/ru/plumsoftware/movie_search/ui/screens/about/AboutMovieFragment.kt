package ru.plumsoftware.movie_search.ui.screens.about

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.plumsoftware.data.model.ui.Movie
import ru.plumsoftware.movie_search.R
import ru.plumsoftware.movie_search.ui.components.CenterTopAppBar
import ru.plumsoftware.movie_search.ui.theme.Extensions
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
                    AboutMovieContent(activity = requireActivity())
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

    @Composable
    private fun AboutMovieContent(activity: Activity) {

        val state = aboutMovieViewModel.state.collectAsState()
        val navController = Navigation.findNavController(activity, R.id.nav_host_fragment)

        Scaffold(
            topBar = {
                CenterTopAppBar(
                    title = state.value.selectedMovie.name,
                    navIcon = {
                        IconButton(
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = Color.Transparent,

                                ),
                            onClick = {
                                navController.navigateUp()
                            }) {
                            Icon(
                                imageVector = Icons.Rounded.ArrowBack,
                                contentDescription = Icons.Rounded.ArrowBack.name
                            )
                        }
                    }
                )
            }
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(it)
                    .padding(horizontal = Extensions.Padding.mediumHor)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(
                    space = Extensions.Space.large,
                    alignment = Alignment.Top
                ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Card (
                        modifier = Modifier
                            .wrapContentSize()
                            .clip(MaterialTheme.shapes.extraSmall),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent
                        ),
                        shape = MaterialTheme.shapes.extraSmall
                    ) {
                        AsyncImage(
                            modifier = Modifier
                                .height(Extensions.Size.previewHeight)
                                .width(Extensions.Size.previewWidth)
                                .clip(MaterialTheme.shapes.extraSmall),
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(state.value.selectedMovie.preview)
                                .build(),
                            error = painterResource(R.drawable.no_preview),
                            placeholder = painterResource(R.drawable.no_preview),
                            contentDescription = state.value.selectedMovie.localizedName,
                        )
                    }
                }
                item {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(
                            space = Extensions.Space.small,
                            alignment = Alignment.CenterVertically
                        ),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = state.value.selectedMovie.localizedName,
                            style = MaterialTheme.typography.labelLarge,
                            textAlign = TextAlign.Start,
                            softWrap = true
                        )
                    }
                }
            }
        }
    }
}