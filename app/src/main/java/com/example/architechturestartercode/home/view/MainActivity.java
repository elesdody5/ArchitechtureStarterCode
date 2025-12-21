package com.example.architechturestartercode.home.controller;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.architechturestartercode.R;
import com.example.architechturestartercode.details.DetailsActivity;
import com.example.architechturestartercode.home.view.MovieAdapter;
import com.example.architechturestartercode.home.view.OnMovieClicked;
import com.example.architechturestartercode.model.movie.Movie;
import com.example.architechturestartercode.network.moviedatasource.MovieResponseCallback;
import com.example.architechturestartercode.network.moviedatasource.RemoteDataSource;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMovieClicked {

    RecyclerView movieRecyclerView;
    MovieAdapter movieAdapter;
    ProgressBar progressBar;
    TextView errorTextView;
    RemoteDataSource remoteDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieRecyclerView = findViewById(R.id.moviesRecyclerView);
        progressBar = findViewById(R.id.progress_bar);
        errorTextView = findViewById(R.id.errorTextView);
        movieAdapter = new MovieAdapter(this);
        movieRecyclerView.setAdapter(movieAdapter);
        errorTextView.setVisibility(INVISIBLE);
        remoteDataSource = new RemoteDataSource();
        remoteDataSource.getMovies(new MovieResponseCallback() {
            @Override
            public void onSuccess(List<Movie> movies) {
                progressBar.setVisibility(INVISIBLE);
                movieAdapter.setMovieList(movies);
            }

            @Override
            public void onFailure(String message) {
                progressBar.setVisibility(INVISIBLE);
                errorTextView.setVisibility(VISIBLE);
                errorTextView.setText("Error: " + message);
            }

            @Override
            public void onNoNetwork() {
                progressBar.setVisibility(INVISIBLE);
                errorTextView.setVisibility(VISIBLE);
                errorTextView.setText("No Network Connection");
            }

            @Override
            public void onTimeOut() {
                progressBar.setVisibility(INVISIBLE);
                errorTextView.setVisibility(VISIBLE);
                errorTextView.setText("Request Timed Out");
            }
        });

    }


    @Override
    public void onMovieClick(Long movieId) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("movieId", movieId);
        startActivity(intent);
    }
}