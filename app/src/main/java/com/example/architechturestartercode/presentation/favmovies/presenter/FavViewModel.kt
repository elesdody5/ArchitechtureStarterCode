package com.example.architechturestartercode.presentation.favmovies.presenter

import android.app.Application
import androidx.core.R
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.architechturestartercode.data.movie.MoviesRepository
import com.example.architechturestartercode.data.movie.model.Movie
import kotlinx.coroutines.launch

class FavViewModel(private val app: Application) : AndroidViewModel(app) {

    private val moviesRepository = MoviesRepository(app)
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

