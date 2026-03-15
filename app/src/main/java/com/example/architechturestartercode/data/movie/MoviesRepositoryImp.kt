package com.example.architechturestartercode.data.movie

import androidx.lifecycle.LiveData
import com.example.architechturestartercode.data.movie.datasource.local.IMoviesLocalDataSource
import com.example.architechturestartercode.data.movie.datasource.local.MoviesLocalDataSource
import com.example.architechturestartercode.data.movie.datasource.remote.IMoviesRemoteDataSource
import com.example.architechturestartercode.data.movie.datasource.remote.MoviesRemoteDataSource
import com.example.architechturestartercode.data.movie.model.Movie
import javax.inject.Inject

class MoviesRepositoryImp @Inject constructor(
    private val remoteDataSource: IMoviesRemoteDataSource,
    private val localDataSource: IMoviesLocalDataSource,
) : IMoviesRepository {


    override suspend fun getAllMovies(): Result<List<Movie>> {
        return remoteDataSource.getAllMovies()
    }

    override suspend fun insertMovieToFav(movie: Movie) {
        localDataSource.insertMovie(movie)
    }

    override suspend fun deleteMovieFromFav(movie: Movie) {
        localDataSource.deleteMovie(movie)
    }

    override fun getAllFavMovies(): LiveData<List<Movie>> {
        return localDataSource.getAllMovies()
    }
}

