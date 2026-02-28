package com.example.architechturestartercode.data.movie.datasource.remote

import com.example.architechturestartercode.data.movie.model.MovieResponse
import com.example.architechturestartercode.data.network.Network
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MoviesRemoteDataSource {
    private val moviesService: MoviesService = Network.moviesService

    fun getAllMovies(callback: MoviesNetworkResponse) {
        moviesService.getMovies().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.code() == 200) {
                    callback.onSuccess(response.body()!!.results)
                } else {
                    callback.serverError("Error code: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                if (t is IOException) {
                    callback.onFailure("Network failure, please try again")
                } else {
                    callback.onFailure("Conversion issue! Big problems :(")
                }
            }
        })
    }
}

