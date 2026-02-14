package com.example.architechturestartercode.data.movie.datasource.remote

import com.example.architechturestartercode.data.movie.model.Movie
import com.example.architechturestartercode.network.Network

class MoviesRemoteDataSource {
    private val movieService: MovieService

    init {
        movieService = Network.instance!!.movieService!!
    }

    suspend fun getMovies(): List<Movie>? {
        val response = movieService.movies()
        return response?.results
    }
}
