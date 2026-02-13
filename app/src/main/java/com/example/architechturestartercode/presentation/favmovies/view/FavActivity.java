package com.example.architechturestartercode.presentation.favmovies.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.architechturestartercode.R;
import com.example.architechturestartercode.data.movie.model.Movie;
import com.example.architechturestartercode.presentation.favmovies.presenter.FavPresenter;
import com.example.architechturestartercode.presentation.favmovies.presenter.FavPresenterImp;

import java.util.List;

public class FavActivity extends AppCompatActivity implements OnFavoriteClickListener, FavView {
    RecyclerView recyclerView;
    FavoriteAdapter adapter;
    FavPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_movies);
        recyclerView = findViewById(R.id.rvFavMovies);
        adapter = new FavoriteAdapter(this);
        recyclerView.setAdapter(adapter);
        presenter = new FavPresenterImp(getApplicationContext(), this);
        presenter.getFavMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                adapter.setList(movies);
            }
        });
    }


    @Override
    public void onMovieDeleted() {
        Toast.makeText(this, "Movie deleted from favorites", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(Movie movie) {
        presenter.deleteMovieFromFav(movie);
    }
}