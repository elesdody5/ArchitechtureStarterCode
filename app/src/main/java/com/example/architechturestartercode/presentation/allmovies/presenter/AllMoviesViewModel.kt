package com.example.architechturestartercode.presentation.allmovies.presenter

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

class AllMoviesViewModel(val moviesRepository: MoviesRepository) : ViewModel() {

//    private val moviesRepository = MoviesRepository(app)

    var isLoading by mutableStateOf(false)
        private set

    private val _allMovies = mutableStateOf<List<Movie>>(emptyList())
    val allMovies: State<List<Movie>>
        get() = _allMovies

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    private val _addedToFavSuccess = MutableLiveData<Boolean>()
    val addedToFavSuccess: LiveData<Boolean> = _addedToFavSuccess

    init {
        getAllMovies()
    }


    fun getAllMovies() {
        isLoading = true
        viewModelScope.launch {
            val result = moviesRepository.getAllMovies()
            result.onSuccess {
                isLoading= false
                _allMovies.value = it
            }.onFailure {
                isLoading = false
                _error.value = "Couldn't load movies, ${it.message}"
            }
        }
    }

    fun addToFav(movie: Movie) {
        viewModelScope.launch {
            try {
                moviesRepository.insertMovieToFav(movie)
                _addedToFavSuccess.value = true
            } catch (e: Exception) {
                _addedToFavSuccess.value = false
                _error.value = "Couldn't Add Movie, ${e.message}"
            }
        }
    }

}

@Suppress("UNCHECKED_CAST")
class AllMoviesViewModelFactory(val repo: MoviesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AllMoviesViewModel(repo) as T
    }
}

