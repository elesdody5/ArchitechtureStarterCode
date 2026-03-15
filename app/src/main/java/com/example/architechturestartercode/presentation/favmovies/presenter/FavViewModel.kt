package com.example.architechturestartercode.presentation.favmovies.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.architechturestartercode.data.movie.MoviesRepositoryImp
import com.example.architechturestartercode.data.movie.model.Movie
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavViewModel @Inject constructor(private val moviesRepository: MoviesRepositoryImp) : ViewModel() {

    private val _onDeleteFromFavSuccess = MutableLiveData<Boolean>()
    val onDeleteFromFavSuccess: LiveData<Boolean>
        get() = _onDeleteFromFavSuccess

    fun getFavMovies(): LiveData<List<Movie>> {
        return moviesRepository.getAllFavMovies()
    }

    fun deleteFavMovie(movie: Movie) {
        viewModelScope.launch {
            moviesRepository.deleteMovieFromFav(movie)
            _onDeleteFromFavSuccess.value = true
        }
    }
}

