package com.example.architechturestartercode.allmovies;

import static android.view.View.GONE;
import static android.view.View.INVISIBLE;
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

public class AllMoviesActivity extends AppCompatActivity implements OnMovieClicked {
    RecyclerView moviesRecyclerView;
    MovieAdapter adapter;
    MoviesRemoteDataSource remoteDataSource;
    MoviesLocalDataSource localDataSource;
    ProgressBar progressBar;
    TextView errorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_movies);
        moviesRecyclerView = findViewById(R.id.rv_movies);
        progressBar = findViewById(R.id.progress_circular);
        errorTextView = findViewById(R.id.error_tv);
        progressBar.setVisibility(VISIBLE);
        errorTextView.setVisibility(GONE);
        adapter = new MovieAdapter(this);
        moviesRecyclerView.setAdapter(adapter);
        localDataSource = new MoviesLocalDataSource(getApplicationContext());
        remoteDataSource = new MoviesRemoteDataSource();
        remoteDataSource.getAllMovies(new MoviesNetworkResponse() {
            @Override
            public void onSuccess(List<Movie> movies) {
                progressBar.setVisibility(INVISIBLE);
                adapter.setMovieList(movies);
            }

            @Override
            public void onFailure(String errorMessage) {
                progressBar.setVisibility(INVISIBLE);
                errorTextView.setVisibility(VISIBLE);
                errorTextView.setText(errorMessage);
            }

            @Override
            public void serverError(String errorMessage) {
                progressBar.setVisibility(INVISIBLE);
                errorTextView.setVisibility(VISIBLE);
                errorTextView.setText(errorMessage);
            }
        });
    }

    @Override
    public void addToFav(Movie movie) {
        localDataSource.insertMovie(movie);
        Toast.makeText(this, "Added to Favorites", Toast.LENGTH_SHORT).show();
    }
}