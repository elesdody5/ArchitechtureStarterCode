package com.example.architechturestartercode.data.movie

import androidx.lifecycle.LiveData
import com.example.architechturestartercode.data.movie.datasource.local.MoviesLocalDataSource
import com.example.architechturestartercode.data.movie.datasource.remote.MoviesRemoteDataSource
import com.example.architechturestartercode.data.movie.model.Movie

class MoviesRepository(
    private val remoteDataSource: MoviesRemoteDataSource,
    private val localDataSource: MoviesLocalDataSource,
) {


    suspend fun getAllMovies(): Result<List<Movie>> {
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

