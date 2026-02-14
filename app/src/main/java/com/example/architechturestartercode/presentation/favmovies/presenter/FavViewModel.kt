package com.example.architechturestartercode.presentation.favmovies.presenter;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.architechturestartercode.data.movie.datasource.local.MoviesLocalDataSource;
import com.example.architechturestartercode.presentation.favmovies.view.FavView;
import com.example.architechturestartercode.data.movie.model.Movie;

import java.util.List;

public class FavPresenterImp implements FavPresenter {
    private MoviesLocalDataSource moviesLocalDataSource;
    private FavView favView;
    public FavPresenterImp(Context context, FavView favView) {
        this.moviesLocalDataSource = new MoviesLocalDataSource(context);
        this.favView = favView;
    }

    public LiveData<List<Movie>> getFavMovies() {
        return moviesLocalDataSource.getMovies();
    }

    public void deleteMovieFromFav(Movie movie) {
        moviesLocalDataSource.deleteMovie(movie);
        favView.onMovieDeleted();
    }
}
