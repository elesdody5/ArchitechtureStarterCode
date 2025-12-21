package com.example.architechturestartercode.details;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.architechturestartercode.R;
import com.example.architechturestartercode.details.contractor.DetailsView;
import com.example.architechturestartercode.details.presenter.DetailsPresenterImp;
import com.example.architechturestartercode.model.movie.Movie;

public class DetailsActivity extends AppCompatActivity implements DetailsView {

    TextView movieIdTextView;
    TextView movieTitleTextView;
    TextView movieDescriptionTextView;
    TextView ratingTextView;
    ImageView movieImageView;
    ProgressBar progressBar;
    TextView errorTextView;
    DetailsPresenterImp presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);
        movieIdTextView = findViewById(R.id.detailMovieIdTextView);
        movieTitleTextView = findViewById(R.id.detailMovieTitleTextView);
        movieDescriptionTextView = findViewById(R.id.detailMovieOverviewTextView);
        ratingTextView = findViewById(R.id.detailMovieRatingTextView);
        movieImageView = findViewById(R.id.detailMoviePosterImageView);
        progressBar = findViewById(R.id.detailProgressBar);
        errorTextView = findViewById(R.id.detailErrorTextView);

        presenter = new DetailsPresenterImp(this);

        Long movieId = getIntent().getLongExtra("movieId", -1);
        presenter.getMovieDetails(movieId);
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
    public void displayMovieDetails(Movie movie) {
        movieIdTextView.setText("ID: " + movie.getId());
        movieTitleTextView.setText("Title: " + movie.getTitle());
        movieDescriptionTextView.setText("Overview: " + movie.getOverview());
        ratingTextView.setText("Rating: " + movie.getRating());
        Glide.with(DetailsActivity.this).load(movie.getImageUrl()).into(movieImageView);
    }
}