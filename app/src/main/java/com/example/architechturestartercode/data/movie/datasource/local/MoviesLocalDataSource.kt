package com.example.architechturestartercode.data.movie.datasource.local

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.architechturestartercode.data.movie.model.Movie
import com.example.architechturestartercode.db.AppDataBase

class MoviesLocalDataSource(context: Context) {
    private val moviesDao: MoviesDao

    init {
        val dataBase: AppDataBase = AppDataBase.Companion.getInstance(context)
        moviesDao = dataBase.moviesDao()!!
    }

    suspend fun insertMovie(movie: Movie) {
        moviesDao.insertMovie(movie)
    }

    suspend fun deleteMovie(movie: Movie) {
        moviesDao.deleteMovie(movie)
    }

    val movies: LiveData<MutableList<Movie>>?
        get() = moviesDao.movies
}
