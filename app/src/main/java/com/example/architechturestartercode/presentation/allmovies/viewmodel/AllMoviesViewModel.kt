package com.example.architechturestartercode.presentation.allmovies.presenter;

import android.content.Context;

import com.example.architechturestartercode.data.movie.MoviesRepository;
import com.example.architechturestartercode.presentation.allmovies.view.AllMoviesView;
import com.example.architechturestartercode.data.movie.datasource.local.MoviesLocalDataSource;
import com.example.architechturestartercode.data.movie.datasource.remote.MoviesNetworkResponse;
import com.example.architechturestartercode.data.movie.datasource.remote.MoviesRemoteDataSource;
import com.example.architechturestartercode.data.movie.model.Movie;

import java.util.List;

public class AllMoviesPresenterImp implements AllMoviesPresenter {
    private MoviesRepository moviesRepository;
    private AllMoviesView allMoviesView;

    public AllMoviesPresenterImp(Context context, AllMoviesView allMoviesView) {
        this.moviesRepository = new MoviesRepository(context);

        this.allMoviesView = allMoviesView;
    }

    public void getAllMovies() {
        moviesRepository.getAllMovies(new MoviesNetworkResponse() {
            @Override
            public void onSuccess(List<Movie> movies) {
                 allMoviesView.onMoviesFetchSuccess(movies);
            }

            @Override
            public void onError(String errorMessage) {
                allMoviesView.onMoviesFetchError(errorMessage);

            }

            @Override
            public void serverError(String serverErrorMessage) {

            }
        });

    }

    public void insertMovieToFav(Movie movie) {
        moviesRepository.insertMovieToFav(movie);
    }
}
