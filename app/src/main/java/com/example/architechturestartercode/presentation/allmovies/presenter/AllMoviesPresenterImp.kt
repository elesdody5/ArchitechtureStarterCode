package com.example.architechturestartercode.presentation.allmovies.presenter

import android.content.Context
import com.example.architechturestartercode.data.movie.MoviesRepository
import com.example.architechturestartercode.data.movie.datasource.remote.MoviesNetworkResponse
import com.example.architechturestartercode.data.movie.model.Movie
import com.example.architechturestartercode.presentation.allmovies.view.AllMoviesView

class AllMoviesPresenterImp(
    context: Context,
    private val allMoviesView: AllMoviesView
) : AllMoviesPresenter {

    private val moviesRepository = MoviesRepository(context)

    override fun getAllMovies() {
        moviesRepository.getAllMovies(object : MoviesNetworkResponse {
            override fun onSuccess(movies: List<Movie>) {
                allMoviesView.hideLoading()
                allMoviesView.setMovies(movies)
            }

            override fun onFailure(errorMessage: String) {
                allMoviesView.hideLoading()
                allMoviesView.showError(errorMessage)
            }

            override fun serverError(errorMessage: String) {
                allMoviesView.hideLoading()
                allMoviesView.showError(errorMessage)
            }
        })
    }

    override fun addToFav(movie: Movie) {
        moviesRepository.insertMovieToFav(movie)
        allMoviesView.onAddToFavSuccess()
    }

    override fun openMovieDetails(movie: Movie) {
        allMoviesView.navigateToDetails(movie)
    }
}

