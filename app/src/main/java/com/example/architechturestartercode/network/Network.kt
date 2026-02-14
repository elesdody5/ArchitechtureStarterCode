package com.example.architechturestartercode.network

import com.example.architechturestartercode.data.movie.datasource.remote.MovieService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network private constructor()  {
     var movieService: MovieService?

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        movieService = retrofit.create<MovieService?>(MovieService::class.java)
    }

    companion object {
        var IMAGE_BASE_URL: String = "https://image.tmdb.org/t/p/w500"
        var instance: Network? = null
            get() {
                if (field == null) {
                    field = Network()
                }
                return field
            }
            private set
    }
}
