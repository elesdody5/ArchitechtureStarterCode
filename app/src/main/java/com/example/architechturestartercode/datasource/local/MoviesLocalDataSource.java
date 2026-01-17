package com.example.architechturestartercode.datasource.local;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.architechturestartercode.db.AppDataBase;
import com.example.architechturestartercode.db.MoviesDao;
import com.example.architechturestartercode.model.Movie;

import java.util.List;

public class MoviesLocalDataSource {
    private MoviesDao moviesDao;

    public MoviesLocalDataSource(Context context) {
        AppDataBase dataBase = AppDataBase.getInstance(context);
        moviesDao = dataBase.moviesDao();
    }

    public void insertMovie(Movie movie) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                moviesDao.insertMovie(movie);
            }
        }).start();

    }

    public void deleteMovie(Movie movie) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                moviesDao.deleteMovie(movie);
            }
        }).start();
    }

    public LiveData<List<Movie>> getMovies() {
        return moviesDao.getMovies();
    }
}
