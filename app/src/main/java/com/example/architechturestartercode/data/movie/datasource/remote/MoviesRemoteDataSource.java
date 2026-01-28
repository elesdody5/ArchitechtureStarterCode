package com.example.architechturestartercode.data.movie.datasource.remote;

import com.example.architechturestartercode.data.movie.model.Movie;
import com.example.architechturestartercode.data.movie.model.MoviesResponse;
import com.example.architechturestartercode.network.Network;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MoviesRemoteDataSource {
    private MovieService movieService;

    public MoviesRemoteDataSource() {
        movieService = Network.getInstance().movieService;
    }

    public void getMovies(MoviesNetworkResponse callback) {
        movieService.getMovies().enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                if (response.isSuccessful()) {
                    List<Movie> movies = response.body().results;
                    callback.onSuccess(movies);
                }
                else {
                    callback.serverError("Server Error! Please try again later.");
                }
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                if (t instanceof IOException) {
                    callback.onError("Network Failure. Please check your internet connection.");
                } else {
                    callback.onError("Conversion issue! Please contact support.");
                }
            }
        });
    }

}
