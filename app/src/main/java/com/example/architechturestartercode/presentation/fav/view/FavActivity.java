package com.example.architechturestartercode.presentation.fav.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.architechturestartercode.R;
import com.example.architechturestartercode.presentation.fav.presenter.FavPresenter;
import com.example.architechturestartercode.data.movies.model.Movie;
import com.example.architechturestartercode.presentation.fav.presenter.FavPresenterImp;

import java.util.List;

public class FavActivity extends AppCompatActivity implements OnFavouriteClickListener , FavView {
    RecyclerView favRecycler;
    FavoriteAdapter favAdapter;
    FavPresenter favPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_movies);
        favAdapter = new FavoriteAdapter(this);
        favRecycler = findViewById(R.id.rvFavMovies);
        favRecycler.setAdapter(favAdapter);
        favPresenter = new FavPresenterImp(getApplicationContext(),this);
        favPresenter.getFavMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                favAdapter.setList(movies);
            }
        });
    }

    @Override
    public void onClick(Movie movie) {
        favPresenter.deleteFromFav(movie);
    }

    @Override
    public void onMovieDeleted() {
        Toast.makeText(this, "Movie removed from favorites", Toast.LENGTH_SHORT).show();
    }
}