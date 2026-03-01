package com.example.architechturestartercode.data.movie

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.architechturestartercode.data.movie.datasource.local.MoviesLocalDataSource
import com.example.architechturestartercode.data.movie.datasource.remote.MoviesRemoteDataSource
import com.example.architechturestartercode.data.movie.model.Movie

class MoviesRepository(context: Context) {
    private val remoteDataSource = MoviesRemoteDataSource()
    private val localDataSource = MoviesLocalDataSource(context)

    suspend fun getAllMovies(): List<Movie> {
        return remoteDataSource.getAllMovies()
    }

    suspend fun insertMovieToFav(movie: Movie) {
        localDataSource.insertMovie(movie)
    }

    suspend fun deleteMovieFromFav(movie: Movie) {
        localDataSource.deleteMovie(movie)
    }

    fun getAllFavMovies(): LiveData<List<Movie>> {
        return localDataSource.getAllMovies()
    }
}

