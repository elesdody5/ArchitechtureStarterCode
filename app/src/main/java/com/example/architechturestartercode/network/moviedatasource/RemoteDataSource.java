package com.example.architechturestartercode.network.moviedatasource;

import com.example.architechturestartercode.model.movie.Movie;
import com.example.architechturestartercode.model.movie.MoviesResponse;
import com.example.architechturestartercode.network.Network;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RemoteDataSource {
    private MovieService movieService;

    public RemoteDataSource() {
        movieService = Network.getInstance().getMovieService();
    }

    public void getMovies(MovieResponseCallback callback) {
        movieService.getMovies().enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                List<Movie> movies = response.body().results;
                callback.onSuccess(movies);
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                if (t instanceof java.net.SocketTimeoutException) {
                    callback.onTimeOut();
                } else if (t instanceof java.io.IOException) {
                    callback.onNoNetwork();
                } else {
                    callback.onFailure(t.getMessage());
                }
            }
        });
    }
}
