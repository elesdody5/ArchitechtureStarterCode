package com.example.architechturestartercode.details.presenter;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import com.example.architechturestartercode.details.contractor.DetailsPresenter;
import com.example.architechturestartercode.details.contractor.DetailsView;
import com.example.architechturestartercode.model.movie.Movie;
import com.example.architechturestartercode.network.moviedatasource.MovieByIdResponse;
import com.example.architechturestartercode.network.moviedatasource.RemoteDataSource;

public class DetailsPresenterImp implements DetailsPresenter {
    RemoteDataSource remoteDataSource;
    DetailsView view;

    public DetailsPresenterImp(DetailsView view) {
        remoteDataSource = new RemoteDataSource();
        this.view = view;
    }

    @Override
    public void getMovieDetails(Long movieId) {
        view.setProgressVisibility(VISIBLE);
        remoteDataSource.getMovieById(movieId, new MovieByIdResponse() {
            @Override
            public void onSuccess(Movie movie) {
                view.setProgressVisibility(INVISIBLE);
                view.displayMovieDetails(movie);
            }

            @Override
            public void onFailure(String message) {
                view.setProgressVisibility(INVISIBLE);
                view.setErrorMessage(VISIBLE, message);
            }

            @Override
            public void onNoNetwork() {
                view.setProgressVisibility(INVISIBLE);
                view.setErrorMessage(VISIBLE, "No network connection");
            }

            @Override
            public void onTimeOut() {
                view.setProgressVisibility(INVISIBLE);
                view.setErrorMessage(VISIBLE, "Request time out");
            }
        });
    }
}

