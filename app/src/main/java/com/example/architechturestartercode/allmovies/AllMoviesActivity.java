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
import com.example.architechturestartercode.datasource.local.MoviesLocalDataSource;
import com.example.architechturestartercode.datasource.remote.MoviesNetworkResponse;
import com.example.architechturestartercode.datasource.remote.MoviesRemoteDataSource;
import com.example.architechturestartercode.model.Movie;

import java.util.List;

public class AllMoviesActivity extends AppCompatActivity implements  MovieOnClickListener {
    RecyclerView allRecycler;
    MovieAdapter allMoviesAdapter;
    MoviesRemoteDataSource moviesRemoteDataSource;
    MoviesLocalDataSource moviesLocalDataSource;
    ProgressBar progressBar;
    TextView errorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_movies);
        allRecycler = findViewById(R.id.rv_movies);
        allMoviesAdapter = new MovieAdapter(this);
        allRecycler.setAdapter(allMoviesAdapter);
        moviesRemoteDataSource = new MoviesRemoteDataSource();
        moviesLocalDataSource = new MoviesLocalDataSource(this);
        errorTextView = findViewById(R.id.tv_error);
        progressBar = findViewById(R.id.progress_circular);
        progressBar.setVisibility(VISIBLE);

        moviesRemoteDataSource.getMovies(new MoviesNetworkResponse() {
            @Override
            public void onSuccess(List<Movie> movies) {
                progressBar.setVisibility(GONE);
                allMoviesAdapter.setMovieList(movies);
            }

            @Override
            public void onError(String errorMessage) {
                progressBar.setVisibility(GONE);
                errorTextView.setVisibility(VISIBLE);
                errorTextView.setText(errorMessage);
            }

            @Override
            public void serverError(String serverErrorMessage) {

            }
        });

    }

    @Override
    public void addMovieToFav(Movie movie) {
        // save movie
        moviesLocalDataSource.insertMovie(movie);
        Toast.makeText(this, "Movie added to favorites", Toast.LENGTH_SHORT).show();
    }
}