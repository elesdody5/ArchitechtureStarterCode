package com.example.architechturestartercode.data.network;

import com.example.architechturestartercode.data.movie.datasource.remote.MoviesService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {
    private MoviesService moviesService;
    private static Network instance;
    private static Retrofit retrofit;
    public static String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500";

    private Network() {
    }

    public static Network getInstance() {
        if (instance == null) {
            instance = new Network();
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }

    public MoviesService getMoviesService() {
        return retrofit.create(MoviesService.class);
    }
}
