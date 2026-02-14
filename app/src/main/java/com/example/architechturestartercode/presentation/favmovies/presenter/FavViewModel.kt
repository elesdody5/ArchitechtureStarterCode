package com.example.architechturestartercode.presentation.favmovies.presenter

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.architechturestartercode.data.movie.MoviesRepository
import com.example.architechturestartercode.data.movie.model.Movie

class FavViewModel(val app: Application) : AndroidViewModel(app) {
    private val moviesRepository: MoviesRepository
    val success: MutableLiveData<String> = MutableLiveData()

    init {
        this.moviesRepository = MoviesRepository(app)
    }

    fun getFavMovies(): LiveData<MutableList<Movie>>? {
        return moviesRepository.favMovies
    }

    fun deleteMovieFromFav(movie: Movie) {
//        moviesRepository.deleteMovieFromFav(movie)
        success.value = "Movie deleted from favorites successfully"
    }
}
