package ru.plumsoftware.movie_search.ui.components.genre

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.plumsoftware.movie_search.R
import ru.plumsoftware.movie_search.ui.theme.Extensions
import ru.plumsoftware.movie_search.ui.theme.MovieSearchTheme

@Composable
fun GenresList(onGenreClick: (String) -> Unit, initialValue: Int = -1) {

    val genresFromResources = stringArrayResource(R.array.genres)
    var selectedIndex by remember { mutableIntStateOf(initialValue) }

    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = Extensions.Padding.mediumHor,
                    vertical = Extensions.Padding.mediumVer
                ),
            text = stringResource(R.string.title_g),
            style = MaterialTheme.typography.headlineLarge
        )
        genresFromResources.forEachIndexed { index, item ->
            GenreItem(
                title = item,
                isSelected = selectedIndex == index,
                onClick = {
                    selectedIndex = if (selectedIndex == index && selectedIndex > 0)
                        -1
                    else
                        index
                    val genre = if (selectedIndex == -1) "" else item
                    onGenreClick.invoke(genre)
                }
            )
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, showSystemUi = true)
private fun GenresListPreviewLight() {
    MovieSearchTheme {
        Scaffold {
            GenresList(onGenreClick = {})
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, showSystemUi = true)
private fun GenresListPreviewDark() {
    MovieSearchTheme {
        Scaffold {
            GenresList(onGenreClick = {}, initialValue = 2)
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, showSystemUi = true,
    device = "spec:parent=pixel_5,orientation=landscape"
)
private fun GenresListPreviewLandscapeDark() {
    MovieSearchTheme {
        Scaffold {
            GenresList(onGenreClick = {}, initialValue = 2)
        }
    }
}