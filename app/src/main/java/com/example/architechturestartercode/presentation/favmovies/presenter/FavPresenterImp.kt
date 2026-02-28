package com.example.architechturestartercode.presentation.favmovies.presenter

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.architechturestartercode.data.movie.MoviesRepository
import com.example.architechturestartercode.data.movie.model.Movie
import com.example.architechturestartercode.presentation.favmovies.view.FavView

class FavPresenterImp(
    context: Context,
    private val favView: FavView
) : FavPresenter {

    private val moviesRepository = MoviesRepository(context)

    override fun getFavMovies(): LiveData<List<Movie>> {
        return moviesRepository.getAllFavMovies()
    }

    override fun deleteFavMovie(movie: Movie) {
        moviesRepository.deleteMovieFromFav(movie)
        favView.onDeleteFromFavSuccess()
    }
}

