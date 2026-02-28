package com.example.architechturestartercode.presentation.favmovies.presenter;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.architechturestartercode.data.movie.MoviesRepository;
import com.example.architechturestartercode.data.movie.datasource.local.MoviesLocalDataSource;
import com.example.architechturestartercode.presentation.favmovies.view.FavView;
import com.example.architechturestartercode.data.movie.model.Movie;

import java.util.List;

public class FavPresenterImp implements FavPresenter {
    MoviesRepository moviesRepository;
    FavView favView;

    public FavPresenterImp(Context context, FavView favView) {
        this.favView = favView;
        moviesRepository = new MoviesRepository(context);
    }

    @Override
    public LiveData<List<Movie>> getFavMovies() {
        return moviesRepository.getAllFavMovies();
    }

    @Override
    public void deleteFavMovie(Movie movie) {
        moviesRepository.deleteMovieFromFav(movie);
        favView.onDeleteFromFavSuccess();
    }
}
