package com.example.architechturestartercode.data.network

import com.example.architechturestartercode.data.movie.datasource.remote.MoviesService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {
    const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val moviesService: MoviesService by lazy {
        retrofit.create(MoviesService::class.java)
    }
}

