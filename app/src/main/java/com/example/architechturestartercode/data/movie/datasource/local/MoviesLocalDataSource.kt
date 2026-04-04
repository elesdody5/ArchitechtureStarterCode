package com.example.architechturestartercode.data.movie.datasource.local

import androidx.lifecycle.LiveData
import com.example.architechturestartercode.data.movie.datasource.local.model.LocalMovie
import com.example.architechturestartercode.data.movie.datasource.remote.model.RemoteMovie
import javax.inject.Inject

class MoviesLocalDataSource @Inject constructor(private val moviesDao: MoviesDao) :
    IMoviesLocalDataSource {

    override suspend fun insertMovie(localMovie: LocalMovie) {
        moviesDao.insertMovies(localMovie)
    }

    override suspend fun deleteMovie(localMovie: LocalMovie) {
        moviesDao.deleteMovies(localMovie)
    }

    override fun getAllMovies(): LiveData<List<LocalMovie>> {
        return moviesDao.getAllMovies()
    }
}

