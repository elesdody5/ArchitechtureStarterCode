package com.example.architechturestartercode.data.movie.datasource.local

import androidx.lifecycle.LiveData
import com.example.architechturestartercode.data.movie.model.Movie
import javax.inject.Inject

class MoviesLocalDataSource @Inject constructor(private val moviesDao: MoviesDao) :
    IMoviesLocalDataSource {

    override suspend fun insertMovie(movie: Movie) {
        moviesDao.insertMovies(movie)
    }

    override suspend fun deleteMovie(movie: Movie) {
        moviesDao.deleteMovies(movie)
    }

    override fun getAllMovies(): LiveData<List<Movie>> {
        return moviesDao.getAllMovies()
    }
}

