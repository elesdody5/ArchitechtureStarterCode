package com.example.architechturestartercode.presentation.allmovies.view;

import static android.view.View.INVISIBLE;
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
import com.example.architechturestartercode.data.movies.model.Movie;

import java.util.List;

public class AllMoviesActivity extends AppCompatActivity implements OnMovieClick, AllMoviesView {
    RecyclerView allMoviesRecycler;
    MovieAdapter adapter;
    TextView errorTextView;
    ProgressBar loadingProgressBar;
    AllMoviesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_movies);
        allMoviesRecycler = findViewById(R.id.rv_movies);
        adapter = new MovieAdapter(this);
        allMoviesRecycler.setAdapter(adapter);
        presenter = new AllMoviesPresenterImp(getApplication(), this);
        loadingProgressBar = findViewById(R.id.progressBar);
        errorTextView = findViewById(R.id.error_tv);
        presenter.getAllMovies();
    }

    @Override
    public void addToFav(Movie movie) {
        presenter.addToFav(movie);
        Toast.makeText(this, "Movie added to favorites", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        loadingProgressBar.setVisibility(VISIBLE);
    }

    @Override
    public void hideLoading() {
        loadingProgressBar.setVisibility(INVISIBLE);
    }

    @Override
    public void showMovies(List<Movie> movies) {
        adapter.setMovieList(movies);
    }

    @Override
    public void showError(String errorMessage) {
        errorTextView.setVisibility(VISIBLE);
        errorTextView.setText(errorMessage);
    }
}