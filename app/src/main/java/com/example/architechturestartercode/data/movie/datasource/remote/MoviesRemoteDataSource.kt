package com.example.architechturestartercode.data.movie.datasource.remote

import com.example.architechturestartercode.data.movie.model.Movie

class MoviesRemoteDataSource(private val moviesService: MoviesService) {


    suspend fun getAllMovies(): Result<List<Movie>> {
        val response = moviesService.getMovies()
        if (response.isSuccessful) {
            val movies = response.body()?.results ?: emptyList()
            return Result.success(movies)
        } else {
            val e = Exception("Failed to fetch movies: ${response.code()} ${response.message()}")
            return Result.failure(e)
        }
    }
}

