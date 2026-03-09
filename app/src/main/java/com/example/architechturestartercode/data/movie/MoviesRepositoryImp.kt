package com.example.architechturestartercode.data.movie

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.architechturestartercode.data.movie.datasource.local.MoviesLocalDataSource
import com.example.architechturestartercode.data.movie.datasource.remote.MoviesRemoteDataSource
import com.example.architechturestartercode.data.movie.model.toData
import com.example.architechturestartercode.data.movie.model.toDomainList
import com.example.architechturestartercode.domin.moive.model.Movie
import com.example.architechturestartercode.domin.moive.repository.MoviesRepository

class MoviesRepositoryImp(context: Context) : MoviesRepository {
    private val remoteDataSource = MoviesRemoteDataSource()
    private val localDataSource = MoviesLocalDataSource(context)

    override suspend fun getAllMovies(): List<Movie> {
        return remoteDataSource.getAllMovies().toDomainList()
    }

    override suspend fun insertMovieToFav(movie: Movie) {
        localDataSource.insertMovie(movie.toData())
    }

    override suspend fun deleteMovieFromFav(movie: Movie) {
        localDataSource.deleteMovie(movie.toData())
    }

    override fun getAllFavMovies(): LiveData<List<Movie>> {
        return localDataSource.getAllMovies().map { it.toDomainList() }
    }
}

