package com.example.architechturestartercode.presentation.allmovies.presenter

import com.example.architechturestartercode.data.movie.model.Movie

interface AllMoviesPresenter {
    fun getAllMovies()
    fun addToFav(movie: Movie)
    fun openMovieDetails(movie: Movie)
}

