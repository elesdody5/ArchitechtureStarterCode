package com.example.architechturestartercode.presentation.allmovies.presenter

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architechturestartercode.data.movie.IMoviesRepository
import com.example.architechturestartercode.data.movie.model.Movie
import com.example.architechturestartercode.di.DefaultDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllMoviesViewModel @Inject constructor(
    private val moviesRepository: IMoviesRepository,
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher,
) : ViewModel() {


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
                isLoading = false
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


