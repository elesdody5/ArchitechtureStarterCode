package com.example.architechturestartercode.data.movie

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.architechturestartercode.data.movie.datasource.local.MoviesLocalDataSource
import com.example.architechturestartercode.data.movie.datasource.remote.MoviesRemoteDataSource
import com.example.architechturestartercode.data.movie.model.Movie

class MoviesRepository(context: Context) {
    private val moviesRemoteDataSource: MoviesRemoteDataSource
    private val moviesLocalDataSource: MoviesLocalDataSource

    init {
        moviesRemoteDataSource = MoviesRemoteDataSource()
        moviesLocalDataSource = MoviesLocalDataSource(context)
    }

    suspend fun getAllMovies(): List<Movie>? {
        return moviesRemoteDataSource.getMovies()
    }

    val favMovies: LiveData<MutableList<Movie>>?
        get() = moviesLocalDataSource.movies

    suspend fun insertMovieToFav(movie: Movie) {
        moviesLocalDataSource.insertMovie(movie)
    }

    suspend fun deleteMovieFromFav(movie: Movie) {
        moviesLocalDataSource.deleteMovie(movie)
    }
}
