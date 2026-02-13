package com.example.architechturestartercode.data.movie.datasource.remote;

import com.example.architechturestartercode.data.movie.model.MovieResponse;
import com.example.architechturestartercode.data.network.Network;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesRemoteDataSource {
    private MoviesService moviesService;

    public MoviesRemoteDataSource() {
        this.moviesService = Network.getInstance().getMoviesService();
    }

    public void getAllMovies(MoviesNetworkResponse callback) {
        moviesService.getMovies().enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.code() == 200) {
                    callback.onSuccess(response.body().results);
                } else {
                    callback.serverError("Error code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                if (t instanceof java.io.IOException) {
                    callback.onFailure("Network failure, please try again");
                } else {
                    callback.onFailure("Conversion issue! Big problems :(");
                }
            }
        });
    }

}
