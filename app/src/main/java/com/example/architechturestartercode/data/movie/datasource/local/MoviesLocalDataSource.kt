package com.example.architechturestartercode.data.movie.datasource.local

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.architechturestartercode.data.db.AppDatabase
import com.example.architechturestartercode.data.movie.model.Movie

class MoviesLocalDataSource(context: Context) {
    private val moviesDao: MoviesDao = AppDatabase.getInstance(context).moviesDao()

    fun insertMovie(movie: Movie) {
        Thread { moviesDao.insertMovies(movie) }.start()
    }

    fun deleteMovie(movie: Movie) {
        Thread { moviesDao.deleteMovies(movie) }.start()
    }

    fun getAllMovies(): LiveData<List<Movie>> {
        return moviesDao.getAllMovies()
    }
}

