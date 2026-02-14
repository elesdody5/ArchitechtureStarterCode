package com.example.architechturestartercode.data.movie.datasource.remote

import com.example.architechturestartercode.data.movie.model.MoviesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.http.GET

interface MovieService {
    @GET("discover/movie?api_key=71ddca1effa9f38a5f61afe803adb266")
    suspend fun movies(): MoviesResponse?
}
