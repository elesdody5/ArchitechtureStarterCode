package com.example.architechturestartercode.allmovies;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.architechturestartercode.R;
import com.example.architechturestartercode.datasource.movies.local.MoviesLocalDataSource;
import com.example.architechturestartercode.datasource.movies.remote.MoviesNetworkResponse;
import com.example.architechturestartercode.datasource.movies.remote.MoviesRemoteDataSource;
import com.example.architechturestartercode.model.Movie;

import java.util.List;

public class AllMoviesActivity extends AppCompatActivity implements OnMovieClick {
    RecyclerView allMoviesRecycler;
    MovieAdapter adapter;
    MoviesRemoteDataSource moviesRemoteDataSource;
    TextView errorTextView;
    ProgressBar loadingProgressBar;
    MoviesLocalDataSource moviesLocalDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_movies);
        allMoviesRecycler = findViewById(R.id.rv_movies);
        adapter = new MovieAdapter(this);
        allMoviesRecycler.setAdapter(adapter);
        moviesRemoteDataSource = new MoviesRemoteDataSource();
        moviesLocalDataSource = new MoviesLocalDataSource(getApplicationContext());
        loadingProgressBar = findViewById(R.id.progressBar);
        errorTextView = findViewById(R.id.error_tv);
        moviesRemoteDataSource.getMovies(new MoviesNetworkResponse() {
            @Override
            public void onSuccess(List<Movie> movies) {
                loadingProgressBar.setVisibility(GONE);
                errorTextView.setVisibility(GONE);
                allMoviesRecycler.setVisibility(VISIBLE);
                adapter.setMovieList(movies);
            }

            @Override
            public void noInternet() {
                loadingProgressBar.setVisibility(GONE);
                errorTextView.setVisibility(VISIBLE);
                errorTextView.setText("No Internet Connection");
            }

            @Override
            public void onFailure(String errorMessage) {
                loadingProgressBar.setVisibility(GONE);
                errorTextView.setVisibility(VISIBLE);
                errorTextView.setText("Something went wrong: " + errorMessage);
            }
        });

    }

    @Override
    public void addToFav(Movie movie) {
        moviesLocalDataSource.insertMovie(movie);
        Toast.makeText(this, "Movie added to favorites", Toast.LENGTH_SHORT).show();
    }
}