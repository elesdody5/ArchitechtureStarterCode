package com.example.architechturestartercode.presentation.allmovies.presenter

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.architechturestartercode.data.movie.MoviesRepository
import com.example.architechturestartercode.data.movie.model.Movie
import kotlinx.coroutines.launch

class AllMoviesViewModel(val app: Application) : AndroidViewModel(app) {

    private val moviesRepository = MoviesRepository(app)

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _allMovies = mutableStateOf(emptyList<Movie>())
    val allMovies: State<List<Movie>>
        get() = _allMovies

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    private val _addSuccess = MutableLiveData<Boolean>()
    val addSuccess: LiveData<Boolean>
        get() = _addSuccess


    init {
        getAllMovies()
    }

    fun getAllMovies() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val movies = moviesRepository.getAllMovies()
                _isLoading.value = false
                _allMovies.value = movies
            } catch (ex: Exception) {
                _isLoading.value = false
                _error.value = ex.message
            }
        }

    }

    fun addToFav(movie: Movie) {
        viewModelScope.launch {
            moviesRepository.insertMovieToFav(movie)
            _addSuccess.value = true
        }
    }

}

