package com.example.architechturestartercode.domin.moive.repository

import androidx.lifecycle.LiveData
import com.example.architechturestartercode.domin.moive.model.Movie

interface MoviesRepository {
    suspend fun getAllMovies(): List<Movie>

    suspend fun insertMovieToFav(remoteMovieResponse: Movie)

    suspend fun deleteMovieFromFav(remoteMovieResponse: Movie)

    fun getAllFavMovies(): LiveData<List<Movie>>
}