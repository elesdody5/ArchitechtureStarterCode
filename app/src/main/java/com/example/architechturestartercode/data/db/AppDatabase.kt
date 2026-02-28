package com.example.architechturestartercode.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.architechturestartercode.data.movie.datasource.local.MoviesDao;
import com.example.architechturestartercode.data.movie.model.Movie;

@Database(entities = {Movie.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MoviesDao moviesDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getINSTANCE(Context context) {
        if (INSTANCE == null) {
            AppDatabase db = Room.databaseBuilder(context,
                    AppDatabase.class, "movies_db")
                    .build();
            INSTANCE = db;
        }
        return INSTANCE;
    }
}
