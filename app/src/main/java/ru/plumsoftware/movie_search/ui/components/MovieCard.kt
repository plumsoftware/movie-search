package ru.plumsoftware.movie_search.ui.components

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import ru.plumsoftware.movie_search.R
import ru.plumsoftware.movie_search.ui.model.Movie
import ru.plumsoftware.movie_search.ui.theme.Extensions
import ru.plumsoftware.movie_search.ui.theme.MovieSearchTheme

@Composable
fun MovieCard(modifier: Modifier = Modifier, movie: Movie, onClick: (Movie) -> Unit) {

    val isPreviewNull = movie.preview == null

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .then(modifier),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        shape = MaterialTheme.shapes.extraSmall,
        onClick = {
            onClick(movie)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(
                space = Extensions.Space.small,
                alignment = Alignment.CenterVertically
            )
        ) {
            Box(
                modifier = Modifier
                    .height(Extensions.Size.previewHeight)
                    .fillMaxWidth()
                    .background(if (isPreviewNull) MaterialTheme.colorScheme.onBackground.copy(alpha = Extensions.Alpha.noPreviewBackAlpha) else Color.Transparent)
                    .clip(MaterialTheme.shapes.extraSmall),
            ) {
                if (isPreviewNull)
                    Icon(
                        modifier = Modifier.align(Alignment.Center),
                        painter = painterResource(R.drawable.no_preview),
                        contentDescription = movie.name,
                        tint = MaterialTheme.colorScheme.onBackground.copy(alpha = Extensions.Alpha.noPreviewTintAlpha)
                    )
                else
                    AsyncImage(
                        model = movie.preview,
                        contentDescription = movie.name,
                    )
            }
            Text(
                text = movie.name,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Start
            )
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true, showSystemUi = true)
@Composable
private fun MovieCardPreviewLight() {
    MovieSearchTheme {
        Scaffold {
            Column {
                MovieCard(
                    movie = Movie(
                        preview = null,
                        name = "Some name",
                        genres = arrayOf("хи-хи"),
                        description = "",
                        localizedName = ""
                    ),
                    onClick = {}
                )
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, showSystemUi = true)
@Composable
private fun MovieCardPreviewDark() {
    MovieSearchTheme {
        Scaffold {
            Column {
                MovieCard(
                    movie = Movie(
                        preview = null,
                        name = "Some name",
                        genres = arrayOf("хи-хи"),
                        description = "",
                        localizedName = ""
                    ),
                    onClick = {}
                )
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES,
    device = "spec:parent=pixel_5,orientation=landscape",
    showBackground = true, showSystemUi = true)
@Composable
private fun MovieCardPreviewDarkLandscape() {
    MovieSearchTheme {
        Scaffold {
            Column {
                MovieCard(
                    movie = Movie(
                        preview = null,
                        name = "Some name",
                        genres = arrayOf("хи-хи"),
                        description = "",
                        localizedName = ""
                    ),
                    onClick = {}
                )
            }
        }
    }
}