package ru.plumsoftware.movie_search.ui.components

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import ru.plumsoftware.movie_search.R
import ru.plumsoftware.movie_search.ui.theme.MovieSearchTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterTopAppBar(
    modifier: Modifier = Modifier,
    navIcon: @Composable () -> Unit = {},
    title: String = stringResource(id = R.string.main_screen_title)
) {
    val colors = TopAppBarDefaults.topAppBarColors(
        containerColor = MaterialTheme.colorScheme.primary,
        titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
    )
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        colors = colors,
        modifier = modifier,
        navigationIcon = navIcon
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true, showSystemUi = true, device = "spec:parent=pixel_5",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun CenterTopAppBarPreview() {
    MovieSearchTheme {
        Scaffold(topBar = {CenterTopAppBar()}) {}
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true, showSystemUi = true, device = "spec:parent=pixel_5",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun CenterTopAppBarDarkPreview() {
    MovieSearchTheme {
        Scaffold(topBar = {CenterTopAppBar()}) {}
    }
}