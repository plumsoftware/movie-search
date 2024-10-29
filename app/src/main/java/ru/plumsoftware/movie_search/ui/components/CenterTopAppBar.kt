package ru.plumsoftware.movie_search.ui.components

import android.annotation.SuppressLint
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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
        containerColor = MaterialTheme.colorScheme.primary
    )
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium
            )
        },
        colors = colors,
        modifier = modifier,
        navigationIcon = navIcon
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
private fun CenterTopAppBarPreview() {
    MovieSearchTheme {
        Scaffold(topBar = {CenterTopAppBar()}) {}
    }
}