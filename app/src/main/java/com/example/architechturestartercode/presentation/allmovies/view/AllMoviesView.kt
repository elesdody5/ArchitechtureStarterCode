package com.example.architechturestartercode.presentation.allmovies.view

import com.example.architechturestartercode.data.movie.model.Movie

interface AllMoviesView {
    fun showLoading()
    fun hideLoading()
    fun setMovies(movies: List<Movie>)
    fun showError(errorMessage: String)
    fun onAddToFavSuccess()
    fun navigateToDetails(movie: Movie)
}

