package com.example.architechturestartercode.datasource.local;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.architechturestartercode.db.AppDatabase;
import com.example.architechturestartercode.model.Movie;

import java.util.List;

public class MoviesLocalDataSource {
    private MoviesDao moviesDao;

    public MoviesLocalDataSource(Context context) {
        this.moviesDao = AppDatabase.getINSTANCE(context).moviesDao();
    }

    public void insertMovie(Movie movie) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                moviesDao.insertMovies(movie);
            }
        }).start();
    }

    public void deleteMovie(Movie movie) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                moviesDao.deleteMovies(movie);
            }
        }).start();

    }

    public LiveData<List<Movie>> getAllMovies() {
        return moviesDao.getAllMovies();
    }
}
