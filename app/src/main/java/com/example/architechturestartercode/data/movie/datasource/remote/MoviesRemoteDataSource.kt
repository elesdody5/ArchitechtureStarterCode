package com.example.architechturestartercode.data.movie.datasource.remote

import com.example.architechturestartercode.data.movie.model.RemoteMovieResponse
import com.example.architechturestartercode.data.network.Network

class MoviesRemoteDataSource {
    private val moviesService: MoviesService = Network.moviesService

    suspend fun getAllMovies(): List<RemoteMovieResponse> {
        val response = moviesService.getMovies()
        if (response.isSuccessful)
            return response.body()?.results ?: emptyList()
        else
            throw Exception("Failed to fetch movies: ${response.code()} ${response.message()}")
    }
}

