package com.example.architechturestartercode.presentation.favmovies.presenter

import androidx.lifecycle.LiveData
import com.example.architechturestartercode.data.movie.model.Movie

interface FavPresenter {
    fun getFavMovies(): LiveData<List<Movie>>
    fun deleteFavMovie(movie: Movie)
}

