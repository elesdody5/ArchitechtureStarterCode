package com.example.architechturestartercode.data.movies;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.architechturestartercode.data.movies.datasource.movies.local.MoviesLocalDataSource;
import com.example.architechturestartercode.data.movies.datasource.movies.remote.MoviesNetworkResponse;
import com.example.architechturestartercode.data.movies.datasource.movies.remote.MoviesRemoteDataSource;
import com.example.architechturestartercode.data.movies.model.Movie;

import java.util.List;

public class MoviesRepository {
    MoviesLocalDataSource moviesLocalDataSource;
    MoviesRemoteDataSource moviesRemoteDataSource;

    public MoviesRepository(Application application) {
        this.moviesLocalDataSource = new MoviesLocalDataSource(application);
        this.moviesRemoteDataSource = new MoviesRemoteDataSource();
    }

    public  void getAllMovies(MoviesNetworkResponse response) {
        moviesRemoteDataSource.getMovies(response);
    }

    public void addToFav(Movie movie) {
        moviesLocalDataSource.insertMovie(movie);
    }

    public void deleteMovie(Movie movie) {
        moviesLocalDataSource.deleteMovie(movie);
    }

    LiveData<List<Movie>> getFavMovies() {
        return moviesLocalDataSource.getMovies();
    }
}
