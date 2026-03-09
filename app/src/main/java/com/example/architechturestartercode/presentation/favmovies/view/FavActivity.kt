package com.example.architechturestartercode.presentation.favmovies.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.architechturestartercode.data.movie.MoviesRepositoryImp
import com.example.architechturestartercode.domin.moive.model.Movie
import com.example.architechturestartercode.presentation.allmovies.view.MovieItem
import com.example.architechturestartercode.presentation.favmovies.presenter.FavViewModel
import com.example.architechturestartercode.presentation.favmovies.presenter.FavViewModelFactory
import com.example.architechturestartercode.presentation.favmovies.view.ui.theme.ArchitechtureStarterCodeTheme

class FavActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val repository = MoviesRepositoryImp(application)
            val viewModel: FavViewModel = viewModel(factory = FavViewModelFactory(repository))
            ArchitechtureStarterCodeTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = "❤️ My Favorites",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        )
                    }
                ) { innerPadding ->
                    FavMoviesScreen(
                        modifier = Modifier.padding(innerPadding),
                        movie = viewModel.getFavMovies().observeAsState().value ?: emptyList(),
                        delete = { viewModel.deleteFavMovie(it) }
                    )
                }
            }
        }
    }
}

@Composable
fun FavMoviesScreen(
    modifier: Modifier = Modifier,
    movie: List<Movie>,
    delete: (Movie) -> Unit,
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        if (movie.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    modifier = Modifier.size(72.dp),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.4f)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "No favorites yet",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Add movies you love from the movies list",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f)
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
            ) {
                items(movie) { movie ->
                    MovieItem(
                        movie = movie,
                        buttonLabel = "Remove",
                        onClick = { delete(movie) }
                    )
                }
            }
        }
    }
}