package com.example.architechturestartercode.data.movie.datasource.remote

import com.example.architechturestartercode.data.movie.model.Movie

interface MoviesNetworkResponse {
    fun onSuccess(movies: List<Movie>)
    fun onFailure(errorMessage: String)
    fun serverError(errorMessage: String)
}

