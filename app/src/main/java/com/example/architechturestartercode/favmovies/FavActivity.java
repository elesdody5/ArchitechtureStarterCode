package com.example.architechturestartercode.favmovies;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.architechturestartercode.R;
import com.example.architechturestartercode.datasource.local.MoviesLocalDataSource;
import com.example.architechturestartercode.model.Movie;

import java.util.List;

public class FavActivity extends AppCompatActivity implements OnFavoriteClickListener {
    RecyclerView recyclerView;
    FavoriteAdapter adapter;
    MoviesLocalDataSource moviesLocalDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_movies);
        recyclerView = findViewById(R.id.rvFavMovies);
        adapter = new FavoriteAdapter(this);
        recyclerView.setAdapter(adapter);
        moviesLocalDataSource = new MoviesLocalDataSource(getApplicationContext());
        moviesLocalDataSource.getAllMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                adapter.setList(movies);
            }
        });
    }

    @Override
    public void deleteFromFav(Movie movie) {
        moviesLocalDataSource.deleteMovie(movie);
    }
}