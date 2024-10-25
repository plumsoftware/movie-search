package ru.plumsoftware.movie_search.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import ru.plumsoftware.movie_search.ui.model.Movie
import ru.plumsoftware.movie_search.ui.theme.Extensions
import ru.plumsoftware.movie_search.ui.theme.MovieSearchTheme

@Composable
fun ColumnScope.MovieCard(modifier: Modifier = Modifier, movie: Movie, onClick: (Movie) -> Unit) {
    Card(
        modifier = Modifier.wrapContentHeight().then(modifier),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        shape = MaterialTheme.shapes.extraSmall,
        onClick = {
            onClick(movie)
        }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().wrapContentSize().weight(1.0f),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(space = Extensions.Space.small)
        ) {
            AsyncImage(
                model = movie.preview,
                contentDescription = movie.name,
            )
            Text(text = movie.name, style = MaterialTheme.typography.titleLarge, textAlign = TextAlign.Start)
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
private fun MovieCardPreview() {
    MovieSearchTheme {
        Scaffold {
            Column {
                MovieCard(
                    movie = Movie(
                        preview = "https://st.kp.yandex.net/images/film_iphone/iphone360_326.jpg",
                        name = "Some name",
                        genre = ""
                    ),
                    onClick = {}
                )
            }
        }
    }
}