package ru.plumsoftware.movie_search

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.SideEffect
import androidx.fragment.app.add
import androidx.fragment.app.commit
import ru.plumsoftware.movie_search.ui.screens.home.HomeScreenFragment
import ru.plumsoftware.movie_search.ui.theme.MovieSearchTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_container)
        enableEdgeToEdge()

        val fragmentManager = this@MainActivity.supportFragmentManager

        if (savedInstanceState == null) {
            fragmentManager.commit {
                setReorderingAllowed(true)
                add<HomeScreenFragment>(R.id.fragment_container)
                addToBackStack("home")
            }
        }
    }
}
