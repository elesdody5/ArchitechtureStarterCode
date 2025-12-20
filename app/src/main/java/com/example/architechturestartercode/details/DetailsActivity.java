package com.example.architechturestartercode.details;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.architechturestartercode.R;
import com.example.architechturestartercode.model.movie.Movie;
import com.example.architechturestartercode.network.moviedatasource.MovieService;
import com.example.architechturestartercode.network.Network;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsActivity extends AppCompatActivity {

    TextView movieIdTextView;
    TextView movieTitleTextView;
    TextView movieDescriptionTextView;
    TextView ratingTextView;
    ImageView movieImageView;
    MovieService movieService;
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
        movieService = Network.getInstance().getMovieService();
        Long movieId = getIntent().getLongExtra("movieId", -1);

        movieService.getMovieById(movieId).enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                Movie movie = response.body();
                movieIdTextView.setText("ID: " + movie.getId());
                movieTitleTextView.setText("Title: " + movie.getTitle());
                movieDescriptionTextView.setText("Overview: " + movie.getOverview());
                ratingTextView.setText("Rating: " + movie.getRating());
                Glide.with(DetailsActivity.this).load(movie.getImageUrl()).into(movieImageView);
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });

    }
}