package com.example.architechturestartercode.data.movie;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.architechturestartercode.data.movie.datasource.local.MoviesLocalDataSource;
import com.example.architechturestartercode.data.movie.datasource.remote.MoviesNetworkResponse;
import com.example.architechturestartercode.data.movie.datasource.remote.MoviesRemoteDataSource;
import com.example.architechturestartercode.data.movie.model.Movie;

import java.util.List;

public class MoviesRepository {
    MoviesRemoteDataSource remoteDataSource;
    MoviesLocalDataSource localDataSource;

    public MoviesRepository(Context context) {
        remoteDataSource = new MoviesRemoteDataSource();
        localDataSource = new MoviesLocalDataSource(context);
    }

    public void getAllMovies(MoviesNetworkResponse response) {
        remoteDataSource.getAllMovies(response);
    }

    public void insertMovieToFav(Movie movie) {
        localDataSource.insertMovie(movie);
    }

    public void deleteMovieFromFav(Movie movie) {
        localDataSource.deleteMovie(movie);
    }

    public LiveData<List<Movie>> getAllFavMovies() {
        return localDataSource.getAllMovies();
    }
}
