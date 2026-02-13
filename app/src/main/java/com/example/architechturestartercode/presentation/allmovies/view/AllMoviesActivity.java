package com.example.architechturestartercode.presentation.allmovies.view;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.content.Intent;
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

public class AllMoviesActivity extends AppCompatActivity implements OnMovieClicked, AllMoviesView {
    RecyclerView moviesRecyclerView;
    MovieAdapter adapter;
    AllMoviesPresenter presenter;
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
        presenter = new AllMoviesPresenterImp(getApplicationContext(), this);
        presenter.getAllMovies();
    }

    @Override
    public void addToFav(Movie movie) {
        presenter.addToFav(movie);
    }

    public void openMovieDetails(Movie movie) {
        presenter.openMovieDetails(movie);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(GONE);
    }

    @Override
    public void setMovies(List<Movie> movies) {
        adapter.setMovieList(movies);
    }

    @Override
    public void showError(String errorMessage) {
        errorTextView.setVisibility(VISIBLE);
        errorTextView.setText(errorMessage);
    }

    @Override
    public void onAddToFavSuccess() {
        Toast.makeText(this, "Added to Favorites", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToDetails(Movie movie) {
        startActivity(new Intent());
    }
}