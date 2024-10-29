package ru.plumsoftware.movie_search.ui.components.movie

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import ru.plumsoftware.movie_search.R
import ru.plumsoftware.data.model.ui.Movie
import ru.plumsoftware.movie_search.ui.theme.Extensions
import ru.plumsoftware.movie_search.ui.theme.MovieSearchTheme

@Composable
fun RowScope.MovieCard(modifier: Modifier = Modifier, movie: Movie, onClick: (Movie) -> Unit) {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .weight(0.5f)
            .clip(MaterialTheme.shapes.extraSmall)
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
                    .wrapContentSize()
                    .clip(MaterialTheme.shapes.extraSmall)
            ) {
                AsyncImage(
                    modifier = Modifier
                        .height(Extensions.Size.previewHeight)
                        .fillMaxWidth()
                        .clip(MaterialTheme.shapes.extraSmall),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(movie.preview)
                        .build(),
                    error = painterResource(R.drawable.no_preview),
                    placeholder = painterResource(R.drawable.no_preview),
                    contentDescription = movie.localizedName,
                )
            }
            Text(
                text = movie.localizedName,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Start,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
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
            Row {
                MovieCard(
                    movie = Movie(
                        preview = null,
                        name = "Some name",
                        genres = arrayOf("хи-хи"),
                        year = 2024,
                        rating = 5.5f,
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
            Row {
                MovieCard(
                    movie = Movie(
                        preview = null,
                        name = "Some name",
                        genres = arrayOf("хи-хи"),
                        year = 2024,
                        rating = 5.5f,
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
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    device = "spec:parent=pixel_5,orientation=landscape",
    showBackground = true, showSystemUi = true
)
@Composable
private fun MovieCardPreviewDarkLandscape() {
    MovieSearchTheme {
        Scaffold {
            Row {
                MovieCard(
                    movie = Movie(
                        preview = null,
                        name = "Some name",
                        genres = arrayOf("хи-хи"),
                        year = 2024,
                        rating = 5.5f,
                        description = "",
                        localizedName = ""
                    ),
                    onClick = {}
                )
            }
        }
    }
}