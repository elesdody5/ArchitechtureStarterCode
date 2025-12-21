package com.example.architechturestartercode.home.presenter;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import com.example.architechturestartercode.home.contractor.HomePresenter;
import com.example.architechturestartercode.home.contractor.HomeView;
import com.example.architechturestartercode.model.movie.Movie;
import com.example.architechturestartercode.network.moviedatasource.MovieResponseCallback;
import com.example.architechturestartercode.network.moviedatasource.RemoteDataSource;

import java.util.List;

public class HomePresenterImp implements HomePresenter {
    RemoteDataSource remoteDataSource;
    HomeView view;

    public HomePresenterImp(HomeView view) {
        remoteDataSource = new RemoteDataSource();
        this.view = view;
    }

    @Override
    public  void getMovies() {
        remoteDataSource.getMovies(new MovieResponseCallback() {
            @Override
            public void onSuccess(List<Movie> movies) {
                view.setProgressVisibility(INVISIBLE);
                view.setMoviesList(movies);
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

    @Override
    public void onMovieSelected(Long movieId){
        view.navigateToMovieDetails(movieId);
    }

}
