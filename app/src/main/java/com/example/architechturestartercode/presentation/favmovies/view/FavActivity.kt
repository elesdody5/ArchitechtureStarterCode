package com.example.architechturestartercode.presentation.favmovies.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.architechturestartercode.data.movie.model.Movie

class FavMoviesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FavMoviesScreen()
        }
    }
}

@Composable
fun FavMoviesScreen(
    movies: List<Movie>,
    isLoading: Boolean,
    error: String?,
    deleteFromFav: (Movie) -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // RecyclerView -> LazyColumn
        if (movies.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(movies) { movie ->
                    FavMovieItem(movie = movie) {
                        deleteFromFav(movie)
                    }
                }
            }
        }

        // Loading state
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }

        // Error state
        if (error != null) {
            Text(
                text = error,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                textAlign = TextAlign.Center
            )
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun FavMovieItem(movie: Movie, deleteFromFav: (Movie) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            GlideImage(
                model = movie.getPoster(),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
            Column {
                Text(text = movie.title ?: "")

                Text(text = "Language: ${movie.language}")
                Button(onClick = { deleteFromFav(movie) }) {
                    Text(text = "Delete Favorite")
                }
            }
        }
    }
}
