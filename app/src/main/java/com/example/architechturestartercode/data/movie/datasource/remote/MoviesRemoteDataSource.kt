package com.example.architechturestartercode.data.movie.datasource.remote

import com.example.architechturestartercode.data.movie.datasource.remote.model.RemoteMovie
import javax.inject.Inject

class MoviesRemoteDataSource @Inject constructor(private val moviesService: MoviesService) :
    IMoviesRemoteDataSource {


    override suspend fun getAllMovies(): Result<List<RemoteMovie>> {
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

