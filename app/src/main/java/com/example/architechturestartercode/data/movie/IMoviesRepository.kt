package com.example.architechturestartercode.data.movie

import androidx.lifecycle.LiveData
import com.example.architechturestartercode.data.movie.model.Movie

interface IMoviesRepository {
    suspend fun getAllMovies(): Result<List<Movie>>
    suspend fun insertMovieToFav(movie: Movie)

    suspend fun deleteMovieFromFav(movie: Movie)
    fun getAllFavMovies(): LiveData<List<Movie>>
}