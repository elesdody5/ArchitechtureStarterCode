package com.example.architechturestartercode.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.architechturestartercode.data.movies.datasource.movies.local.MoviesDao;
import com.example.architechturestartercode.data.movies.model.Movie;

@Database(entities = {Movie.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MoviesDao moviesDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context,
                    AppDatabase.class, "moviesDB")
                    .build();
        }
        return INSTANCE;
    }
}
