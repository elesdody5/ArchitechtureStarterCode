package com.example.architechturestartercode.data.movie.datasource.local

import androidx.lifecycle.LiveData
import com.example.architechturestartercode.data.movie.model.Movie

class MoviesLocalDataSource(private val moviesDao: MoviesDao) {

    suspend fun insertMovie(movie: Movie) {
        moviesDao.insertMovies(movie)
    }

    suspend fun deleteMovie(movie: Movie) {
        moviesDao.deleteMovies(movie)
    }

    fun getAllMovies(): LiveData<List<Movie>> {
        return moviesDao.getAllMovies()
    }
}

