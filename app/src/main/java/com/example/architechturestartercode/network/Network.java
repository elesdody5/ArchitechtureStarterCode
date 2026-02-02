package com.example.architechturestartercode.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {
    private MoviesService moviesService;
    private static Network instance;

    private Network() {
    }

    public static Network getInstance() {
        if (instance == null) {
            instance = new Network();
        }
        return instance;
    }

    public MoviesService getMoviesService() {
       Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dummyjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(MoviesService.class);
    }
}
