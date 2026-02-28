package com.example.architechturestartercode.data.movie

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.architechturestartercode.data.movie.datasource.local.MoviesLocalDataSource
import com.example.architechturestartercode.data.movie.datasource.remote.MoviesNetworkResponse
import com.example.architechturestartercode.data.movie.datasource.remote.MoviesRemoteDataSource
import com.example.architechturestartercode.data.movie.model.Movie

class MoviesRepository(context: Context) {
    private val remoteDataSource = MoviesRemoteDataSource()
    private val localDataSource = MoviesLocalDataSource(context)

    fun getAllMovies(response: MoviesNetworkResponse) {
        remoteDataSource.getAllMovies(response)
    }

    fun insertMovieToFav(movie: Movie) {
        localDataSource.insertMovie(movie)
    }

    fun deleteMovieFromFav(movie: Movie) {
        localDataSource.deleteMovie(movie)
    }

    fun getAllFavMovies(): LiveData<List<Movie>> {
        return localDataSource.getAllMovies()
    }
}

