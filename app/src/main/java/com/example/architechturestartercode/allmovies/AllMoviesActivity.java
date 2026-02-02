package com.example.architechturestartercode.allmovies;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.architechturestartercode.R;
import com.example.architechturestartercode.model.Movie;
import com.example.architechturestartercode.model.MovieResponse;
import com.example.architechturestartercode.network.MoviesService;
import com.example.architechturestartercode.network.Network;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllMoviesActivity extends AppCompatActivity {
    RecyclerView moviesRecyclerView;
    MovieAdapter adapter;
    MoviesService moviesService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_movies);
        moviesRecyclerView = findViewById(R.id.rv_movies);
        adapter = new MovieAdapter();
        moviesRecyclerView.setAdapter(adapter);
        moviesService = Network.getInstance().getMoviesService();
        Call<MovieResponse> call = moviesService.getAllMovies();
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if(response.isSuccessful()){

                }
            }
            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
    }
}