package com.example.architechturestartercode.fav;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.architechturestartercode.R;
import com.example.architechturestartercode.datasource.movies.local.MoviesLocalDataSource;
import com.example.architechturestartercode.model.Movie;

import java.util.List;

public class FavActivity extends AppCompatActivity implements OnFavouriteClickListener {
    RecyclerView favRecycler;
    FavoriteAdapter favAdapter;
    MoviesLocalDataSource moviesLocalDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_movies);
        favAdapter = new FavoriteAdapter(this);
        favRecycler = findViewById(R.id.rvFavMovies);
        favRecycler.setAdapter(favAdapter);
        moviesLocalDataSource = new MoviesLocalDataSource(getApplicationContext());
        moviesLocalDataSource.getMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                favAdapter.setList(movies);
            }
        });
    }

    @Override
    public void onClick(Movie movie) {
        moviesLocalDataSource.deleteMovie(movie);
    }
}