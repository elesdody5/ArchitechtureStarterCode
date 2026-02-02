package com.example.architechturestartercode.presentation.allmovies.presenter;

import android.app.Application;

import com.example.architechturestartercode.R;
import com.example.architechturestartercode.data.movies.MoviesRepository;
import com.example.architechturestartercode.data.movies.datasource.movies.remote.MoviesNetworkResponse;
import com.example.architechturestartercode.data.movies.model.Movie;
import com.example.architechturestartercode.presentation.allmovies.view.AllMoviesView;

import java.util.List;

public class AllMoviesPresenterImp implements AllMoviesPresenter {
    MoviesRepository moviesRepository;
    AllMoviesView allMoviesView;

    public AllMoviesPresenterImp(Application application, AllMoviesView allMoviesView) {
        this.moviesRepository = new MoviesRepository(application);
        this.allMoviesView = allMoviesView;
    }

    public void getAllMovies() {
        allMoviesView.showLoading();
        moviesRepository.getAllMovies(new MoviesNetworkResponse() {
            @Override
            public void onSuccess(List<Movie> movies) {
                allMoviesView.hideLoading();
                allMoviesView.showMovies(movies);
            }

            @Override
            public void noInternet() {
                allMoviesView.hideLoading();
                allMoviesView.showError(R.string.no_internet);
            }

            @Override
            public void onFailure(String errorMessage) {
                allMoviesView.hideLoading();
                allMoviesView.showError(errorMessage);
            }
        });

    }

    public void addToFav(Movie movie) {
        moviesRepository.addToFav(movie);
    }
}
