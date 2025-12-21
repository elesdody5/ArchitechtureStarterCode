package com.example.architechturestartercode.home.presenter;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import com.example.architechturestartercode.home.view.MainActivity;
import com.example.architechturestartercode.model.movie.Movie;
import com.example.architechturestartercode.network.moviedatasource.MovieResponseCallback;
import com.example.architechturestartercode.network.moviedatasource.RemoteDataSource;

import java.util.List;

public class HomePresenter {
    RemoteDataSource remoteDataSource;
    MainActivity activity;

    public HomePresenter(MainActivity activity) {
        remoteDataSource = new RemoteDataSource();
        this.activity = activity;
    }

    public  void getMovies() {
        remoteDataSource.getMovies(new MovieResponseCallback() {
            @Override
            public void onSuccess(List<Movie> movies) {
                activity.setProgressVisibility(INVISIBLE);
                activity.setMoviesList(movies);
            }

            @Override
            public void onFailure(String message) {
                activity.setProgressVisibility(INVISIBLE);
                activity.setErrorMessage(VISIBLE, message);
            }

            @Override
            public void onNoNetwork() {
                activity.setProgressVisibility(INVISIBLE);
                activity.setErrorMessage(VISIBLE, "No network connection");
            }

            @Override
            public void onTimeOut() {
                activity.setProgressVisibility(INVISIBLE);
                activity.setErrorMessage(VISIBLE, "Request time out");
            }
        });
    }

    public void onMovieSelected(Long movieId){
        activity.navigateToMovieDetails(movieId);
    }

}
