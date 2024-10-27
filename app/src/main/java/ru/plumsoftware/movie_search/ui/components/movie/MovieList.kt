package ru.plumsoftware.movie_search.ui.components.movie

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.plumsoftware.movie_search.R
import ru.plumsoftware.movie_search.mock.getMockMovieList
import ru.plumsoftware.data.model.ui.Movie
import ru.plumsoftware.movie_search.ui.theme.Extensions
import ru.plumsoftware.movie_search.ui.theme.MovieSearchTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MovieList(movieList: List<Movie>, onMovieClick: (Movie) -> Unit = {}) {
    val padding = PaddingValues(
        horizontal = Extensions.Padding.mediumHor,
        vertical = Extensions.Padding.mediumVer
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding),
            text = stringResource(R.string.main_screen_title),
            style = MaterialTheme.typography.headlineLarge
        )
        FlowRow(
            modifier = Modifier
                .padding(padding)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(
                space = Extensions.Space.medium,
                alignment = Alignment.CenterVertically
            ),
            horizontalArrangement = Arrangement.spacedBy(
                space = Extensions.Space.small,
                alignment = Alignment.CenterHorizontally
            ),
            maxItemsInEachRow = 2
        ) {
            movieList.forEach { item ->
                MovieCard(
                    movie = item,
                    modifier = Modifier
                        .weight(1.0f),
                    onClick = {
                        onMovieClick(item)
                    }
                )
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
private fun MovieListPreviewLight() {
    MovieSearchTheme {
        Scaffold {
            MovieList(movieList = getMockMovieList())
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun MovieListPreviewDark() {
    MovieSearchTheme {
        Scaffold {
            MovieList(movieList = getMockMovieList())
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview(
    showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES,
    device = "spec:parent=pixel_5,orientation=landscape"
)
private fun MovieListPreviewDarkLandscape() {
    MovieSearchTheme {
        Scaffold {
            MovieList(movieList = getMockMovieList())
        }
    }
}