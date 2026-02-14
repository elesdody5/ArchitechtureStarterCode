package com.example.architechturestartercode.data.movie;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.architechturestartercode.data.movie.datasource.local.MoviesLocalDataSource;
import com.example.architechturestartercode.data.movie.datasource.remote.MoviesNetworkResponse;
import com.example.architechturestartercode.data.movie.datasource.remote.MoviesRemoteDataSource;
import com.example.architechturestartercode.data.movie.model.Movie;

import java.util.List;

public class MoviesRepository {
    private MoviesRemoteDataSource moviesRemoteDataSource;
    private MoviesLocalDataSource moviesLocalDataSource;

    public MoviesRepository(Context context) {
        moviesRemoteDataSource = new MoviesRemoteDataSource();
        moviesLocalDataSource = new MoviesLocalDataSource(context);
    }

    public void getAllMovies(MoviesNetworkResponse moviesResponse) {
        moviesRemoteDataSource.getMovies(moviesResponse);
    }

    public LiveData<List<Movie>> getFavMovies() {
        return moviesLocalDataSource.getMovies();
    }
    public void insertMovieToFav(Movie movie) {
        moviesLocalDataSource.insertMovie(movie);
    }
    public void deleteMovieFromFav(Movie movie) {
        moviesLocalDataSource.deleteMovie(movie);
    }
}
