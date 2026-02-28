package com.example.architechturestartercode.presentation.allmovies.presenter;

import android.content.Context;

import com.example.architechturestartercode.data.movie.MoviesRepository;
import com.example.architechturestartercode.presentation.allmovies.view.AllMoviesView;
import com.example.architechturestartercode.data.movie.datasource.local.MoviesLocalDataSource;
import com.example.architechturestartercode.data.movie.datasource.remote.MoviesNetworkResponse;
import com.example.architechturestartercode.data.movie.datasource.remote.MoviesRemoteDataSource;
import com.example.architechturestartercode.data.movie.model.Movie;

import java.util.List;

public class AllMoviesPresenterImp implements AllMoviesPresenter{
    MoviesRepository moviesRepository;
    AllMoviesView allMoviesView;

    public AllMoviesPresenterImp(Context context, AllMoviesView allMoviesView) {
        this.allMoviesView = allMoviesView;
        moviesRepository = new MoviesRepository(context);
    }

    public void getAllMovies() {
       moviesRepository.getAllMovies(new MoviesNetworkResponse() {
            @Override
            public void onSuccess(List<Movie> movies) {
                allMoviesView.hideLoading();
                allMoviesView.setMovies(movies);
            }

            @Override
            public void onFailure(String errorMessage) {
                allMoviesView.hideLoading();
                allMoviesView.showError(errorMessage);
            }

            @Override
            public void serverError(String errorMessage) {
                allMoviesView.hideLoading();
                allMoviesView.showError(errorMessage);
            }
        });
    }

    public void addToFav(Movie movie) {
        moviesRepository.insertMovieToFav(movie);
        allMoviesView.onAddToFavSuccess();
    }

    @Override
    public void openMovieDetails(Movie movie) {
//        localDataSource.insertMovie(movie);
        allMoviesView.navigateToDetails(movie);
    }
}
