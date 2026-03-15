package com.example.architechturestartercode.data.movie.datasource.local

import androidx.lifecycle.LiveData
import com.example.architechturestartercode.data.movie.model.Movie

interface IMoviesLocalDataSource {
    suspend fun insertMovie(movie: Movie)

    suspend fun deleteMovie(movie: Movie)
    fun getAllMovies(): LiveData<List<Movie>>
}