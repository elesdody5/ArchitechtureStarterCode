package com.example.architechturestartercode.data.movie.datasource.local

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.architechturestartercode.data.db.AppDatabase
import com.example.architechturestartercode.data.movie.model.RemoteMovieResponse

class MoviesLocalDataSource(context: Context) {
    private val moviesDao: MoviesDao = AppDatabase.getInstance(context).moviesDao()

    suspend fun insertMovie(remoteMovieResponse: RemoteMovieResponse) {
       moviesDao.insertMovies(remoteMovieResponse)
    }

    suspend fun deleteMovie(remoteMovieResponse: RemoteMovieResponse) {
        moviesDao.deleteMovies(remoteMovieResponse)
    }

    fun getAllMovies(): LiveData<List<RemoteMovieResponse>> {
        return moviesDao.getAllMovies()
    }
}

