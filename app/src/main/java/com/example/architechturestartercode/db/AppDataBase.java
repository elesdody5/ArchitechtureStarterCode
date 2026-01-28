package com.example.architechturestartercode.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.architechturestartercode.data.movie.datasource.local.MoviesDao;
import com.example.architechturestartercode.data.movie.model.Movie;

@Database(entities = {Movie.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract MoviesDao moviesDao();

    private static AppDataBase instance = null;

    public static AppDataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDataBase.class,
                            "moviesdb")
                    .build();
        }
        return instance;
    }
}
