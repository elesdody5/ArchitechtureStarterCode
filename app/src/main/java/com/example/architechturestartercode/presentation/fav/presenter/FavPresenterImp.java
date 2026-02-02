package com.example.architechturestartercode.presentation.fav.presenter;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.architechturestartercode.data.movies.datasource.movies.local.MoviesLocalDataSource;
import com.example.architechturestartercode.presentation.fav.view.FavView;
import com.example.architechturestartercode.data.movies.model.Movie;

import java.util.List;

public class FavPresenterImp implements FavPresenter {
    MoviesLocalDataSource moviesLocalDataSource;
    FavView favView;

    public FavPresenterImp(Context context, FavView favView) {
        this.moviesLocalDataSource = new MoviesLocalDataSource(context);
        this.favView = favView;
    }

    @Override
    public LiveData<List<Movie>> getFavMovies() {
        return moviesLocalDataSource.getMovies();
    }

    @Override
    public void deleteFromFav(Movie movie) {
        try {
            moviesLocalDataSource.deleteMovie(movie);
            favView.onMovieDeleted();
        } catch (Exception e) {

        }
    }
}
