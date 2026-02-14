package com.example.architechturestartercode.presentation.allmovies.view;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.architechturestartercode.R;
import com.example.architechturestartercode.presentation.allmovies.presenter.AllMoviesPresenter;
import com.example.architechturestartercode.presentation.allmovies.presenter.AllMoviesPresenterImp;
import com.example.architechturestartercode.data.movie.model.Movie;

import java.util.List;

public class AllMoviesActivity extends AppCompatActivity implements MovieOnClickListener, AllMoviesView {
    RecyclerView allRecycler;
    MovieAdapter allMoviesAdapter;
    AllMoviesPresenter allMoviesPresenter;
    ProgressBar progressBar;
    TextView errorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_movies);
        allRecycler = findViewById(R.id.rv_movies);
        allMoviesAdapter = new MovieAdapter(this);
        allRecycler.setAdapter(allMoviesAdapter);
        errorTextView = findViewById(R.id.tv_error);
        progressBar = findViewById(R.id.progress_circular);
        progressBar.setVisibility(VISIBLE);
        allMoviesPresenter = new AllMoviesPresenterImp(getApplicationContext(), this);
        allMoviesPresenter.getAllMovies();
    }

    @Override
    public void addMovieToFav(Movie movie) {
        // save movie
        allMoviesPresenter.insertMovieToFav(movie);
        Toast.makeText(this, "Movie added to favorites", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMoviesFetchSuccess(List<Movie> movies) {
        progressBar.setVisibility(GONE);
        allMoviesAdapter.setMovieList(movies);
    }

    @Override
    public void onMoviesFetchError(String errorMessage) {
        progressBar.setVisibility(GONE);
        errorTextView.setVisibility(VISIBLE);
        errorTextView.setText(errorMessage);
    }
}