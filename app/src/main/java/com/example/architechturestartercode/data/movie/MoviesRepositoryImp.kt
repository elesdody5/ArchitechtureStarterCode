package com.example.architechturestartercode.data.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.architechturestartercode.data.movie.datasource.local.IMoviesLocalDataSource
import com.example.architechturestartercode.data.movie.datasource.local.model.toLocalMovie
import com.example.architechturestartercode.data.movie.datasource.remote.IMoviesRemoteDataSource
import com.example.architechturestartercode.data.movie.datasource.remote.model.toMoviesList
import com.example.architechturestartercode.domin.movies.model.Movie
import com.example.architechturestartercode.domin.movies.repo.IMoviesRepository
import okio.IOException
import javax.inject.Inject

class MoviesRepositoryImp @Inject constructor(
    private val remoteDataSource: IMoviesRemoteDataSource,
    private val localDataSource: IMoviesLocalDataSource,
) : IMoviesRepository {


    override suspend fun getAllMovies(): Result<List<Movie>> {
        return remoteDataSource.getAllMovies().getOrNull()?.toMoviesList()
            ?.let { Result.success(it) }
            ?: Result.failure(IOException("Failed to fetch movies from remote data source"))
    }

    override suspend fun insertMovieToFav(movie: Movie) {
        localDataSource.insertMovie(movie.toLocalMovie())
    }

    override suspend fun deleteMovieFromFav(movie: Movie) {
        localDataSource.deleteMovie(movie.toLocalMovie())
    }

    override fun getAllFavMovies(): LiveData<List<Movie>> {
        return localDataSource.getAllMovies().map { localMovies ->
            localMovies.map { localMovie ->
                Movie(
                    id = localMovie.id,
                    title = localMovie.title,
                    language = localMovie.language,
                    posterUrl = localMovie.posterUrl,
                )
            }
        }
    }
}

