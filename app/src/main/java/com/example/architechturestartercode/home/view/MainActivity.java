package com.example.architechturestartercode.home.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.architechturestartercode.R;
import com.example.architechturestartercode.details.DetailsActivity;
import com.example.architechturestartercode.home.contractor.HomeView;
import com.example.architechturestartercode.home.presenter.HomePresenterImp;
import com.example.architechturestartercode.model.movie.Movie;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMovieClicked, HomeView {

    RecyclerView movieRecyclerView;
    MovieAdapter movieAdapter;
    ProgressBar progressBar;
    TextView errorTextView;
    HomePresenterImp presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieRecyclerView = findViewById(R.id.moviesRecyclerView);
        progressBar = findViewById(R.id.progress_bar);
        errorTextView = findViewById(R.id.errorTextView);
        movieAdapter = new MovieAdapter(this);
        movieRecyclerView.setAdapter(movieAdapter);
        presenter = new HomePresenterImp(this);
        presenter.getMovies();
    }

    @Override
    public void setProgressVisibility(int visibility) {
        progressBar.setVisibility(visibility);
    }

    @Override
    public void setErrorMessage(int visibility, String message) {
        errorTextView.setVisibility(visibility);
        errorTextView.setText(message);
    }

    @Override
    public void setMoviesList(List<Movie> movies) {
        movieAdapter.setMovieList(movies);
    }

    @Override
    public void navigateToMovieDetails(Long movieId) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("movieId", movieId);
        startActivity(intent);
    }


    @Override
    public void onMovieClick(Long movieId) {
        presenter.onMovieSelected(movieId);
    }
}