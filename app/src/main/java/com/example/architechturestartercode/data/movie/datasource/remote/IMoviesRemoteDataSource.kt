package com.example.architechturestartercode.data.movie.datasource.remote

import com.example.architechturestartercode.data.movie.datasource.remote.model.RemoteMovie

interface IMoviesRemoteDataSource {
    suspend fun getAllMovies(): Result<List<RemoteMovie>>
}