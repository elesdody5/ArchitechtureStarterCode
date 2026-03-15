package com.example.architechturestartercode.data.movie.datasource.remote

import com.example.architechturestartercode.data.movie.model.Movie

interface IMoviesRemoteDataSource {
    suspend fun getAllMovies(): Result<List<Movie>>
}