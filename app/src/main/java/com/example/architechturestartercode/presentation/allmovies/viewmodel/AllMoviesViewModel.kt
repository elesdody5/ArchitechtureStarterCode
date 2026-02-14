package com.example.architechturestartercode.presentation.allmovies.viewmodel

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.architechturestartercode.data.movie.MoviesRepository
import com.example.architechturestartercode.data.movie.model.Movie
import kotlinx.coroutines.launch

class AllMoviesViewModel(private val moviesRepository: MoviesRepository) : ViewModel() {


    //    private val moviesRepository: MoviesRepository = MoviesRepository(context)
    private val _allMovies: MutableState<List<Movie>> = mutableStateOf(emptyList<Movie>())
    val allMovies: State<List<Movie>>
        get() = _allMovies

    var error by mutableStateOf("")
        private set

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
        getAllMovies()
    }

    fun getAllMovies() {
        try {
            viewModelScope.launch {
                _isLoading.value = true
                val movies = moviesRepository.getAllMovies()
                _isLoading.value = false
                if (movies != null) _allMovies.value = movies
            }
        } catch (e: Exception) {
            error = e.message ?: ""
        }
    }

    fun insertMovieToFav(movie: Movie) {
        viewModelScope.launch {
            moviesRepository.insertMovieToFav(movie)
        }
    }
}

class AllMoviesFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val repository = MoviesRepository(context)
        return AllMoviesViewModel(repository) as T
    }
}
