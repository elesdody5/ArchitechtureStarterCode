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

                if(response.code() == 200) {
                    List<Movie> movies = response.body().results;
                    callback.onSuccess(movies);
                }
                else
                    callback.onFailure("Error code: " + response.code());
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

    public void getMovieById(Long movieId, MovieByIdResponse callback) {
        movieService.getMovieById(movieId).enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if(response.code() == 200) {
                    Movie movie = response.body();
                    callback.onSuccess(movie);
                }
                else
                    callback.onFailure("Error code: " + response.code());
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
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
