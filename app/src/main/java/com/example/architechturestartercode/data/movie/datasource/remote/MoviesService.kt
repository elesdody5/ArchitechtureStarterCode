package com.example.architechturestartercode.data.movie.datasource.remote

import com.example.architechturestartercode.data.movie.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET

interface MoviesService {
    @GET("discover/movie?api_key=71ddca1effa9f38a5f61afe803adb266")
    suspend fun getMovies(): Response<MovieResponse>
}

