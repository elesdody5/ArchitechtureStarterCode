package com.example.architechturestartercode.data.movie.datasource.local

import androidx.lifecycle.LiveData
import com.example.architechturestartercode.data.movie.datasource.local.model.LocalMovie
import com.example.architechturestartercode.data.movie.datasource.remote.model.RemoteMovie

interface IMoviesLocalDataSource {
    suspend fun insertMovie(localMovie: LocalMovie)

    suspend fun deleteMovie(localMovie: LocalMovie)
    fun getAllMovies(): LiveData<List<LocalMovie>>
}