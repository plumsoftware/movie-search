package ru.plumsoftware.movie_search.ui.components.genre

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.plumsoftware.movie_search.ui.theme.Extensions
import ru.plumsoftware.movie_search.ui.theme.MovieSearchTheme

@Composable
fun GenreItem(title: String, isSelected: Boolean, onClick: () -> Unit) {

    val colors = ButtonDefaults.buttonColors(
        containerColor = if (isSelected) MaterialTheme.colorScheme.primaryContainer else Color.Transparent
    )

    Button(
        onClick = onClick,
        colors = colors,
        shape = RoundedCornerShape(0.dp),
        contentPadding = PaddingValues(
            horizontal = Extensions.Padding.mediumHor,
            vertical = Extensions.Padding.mediumVer
        )
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = title,
            style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onBackground),
            textAlign = TextAlign.Start
        )
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showSystemUi = true, showBackground = true)
private fun GenreItemPreviewLight() {
    MovieSearchTheme {
        Scaffold {
            GenreItem(title = "Genre", isSelected = false, onClick = {})
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showSystemUi = true, showBackground = true)
private fun GenreItemPreviewLight2() {
    MovieSearchTheme {
        Scaffold {
            GenreItem(title = "Genre", isSelected = true, onClick = {})
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true, showBackground = true)
private fun GenreItemPreviewDark() {
    MovieSearchTheme {
        Scaffold {
            GenreItem(title = "Genre", isSelected = true, onClick = {})
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true, showBackground = true)
private fun GenreItemPreviewDark2() {
    MovieSearchTheme {
        Scaffold {
            GenreItem(title = "Genre", isSelected = false, onClick = {})
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true, showBackground = true,
    device = "spec:parent=pixel_5,orientation=landscape"
)
private fun GenreItemPreviewDarkLandscape() {
    MovieSearchTheme {
        Scaffold {
            GenreItem(title = "Genre", isSelected = false, onClick = {})
        }
    }
}