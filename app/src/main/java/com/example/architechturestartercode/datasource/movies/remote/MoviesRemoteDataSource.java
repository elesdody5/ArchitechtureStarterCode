package com.example.architechturestartercode.datasource.movies.remote;

import com.example.architechturestartercode.model.Movie;
import com.example.architechturestartercode.model.MoviesResponse;
import com.example.architechturestartercode.network.Network;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesRemoteDataSource {
    private MoviesService moviesService;

    public MoviesRemoteDataSource() {
        this.moviesService = new Network()
                .getMoviesService();
    }

    public void getMovies(MoviesNetworkResponse callback) {
        moviesService.getMovies().enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                if (response.code() == 200) {
                    MoviesResponse moviesResponse = response.body();
                    List<Movie> movies = moviesResponse.getResults();
                    callback.onSuccess(movies);
                } else {
                    callback.onFailure("Error server error");
                }
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                if (t instanceof IOException) {
                    callback.noInternet();
                } else {
                    callback.onFailure("Conversion Error! Please try again.");
                }
            }
        });
    }
}
