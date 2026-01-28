package com.example.architechturestartercode.datasource.movies.local;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.architechturestartercode.db.AppDatabase;
import com.example.architechturestartercode.model.Movie;

import java.util.List;

public class MoviesLocalDataSource {
    private MoviesDao moviesDao;

    public MoviesLocalDataSource(Context context) {
        this.moviesDao = AppDatabase.getInstance(context).moviesDao();
    }

    public LiveData<List<Movie>> getMovies() {
        return moviesDao.getMovies();
    }

    public void insertMovie(Movie movie) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                moviesDao.addToFav(movie);
            }
        }).start();

    }

    public void deleteMovie(Movie movie) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                moviesDao.deleteFromFav(movie);
            }
        }).start();
    }

}
