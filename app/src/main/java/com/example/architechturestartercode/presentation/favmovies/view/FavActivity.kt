package com.example.architechturestartercode.presentation.favmovies.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.architechturestartercode.R
import com.example.architechturestartercode.data.movie.model.Movie
import com.example.architechturestartercode.presentation.favmovies.presenter.FavPresenter
import com.example.architechturestartercode.presentation.favmovies.presenter.FavPresenterImp

class FavActivity : AppCompatActivity(), OnFavoriteClickListener, FavView {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FavoriteAdapter
    private lateinit var presenter: FavPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fav_movies)
        recyclerView = findViewById(R.id.rvFavMovies)
        adapter = FavoriteAdapter(this)
        recyclerView.adapter = adapter
        presenter = FavPresenterImp(applicationContext, this)
        presenter.getFavMovies().observe(this) { movies ->
            adapter.setList(movies)
        }
    }

    override fun deleteFromFav(movie: Movie) {
        presenter.deleteFavMovie(movie)
    }

    override fun onDeleteFromFavSuccess() {
        Toast.makeText(this, "Movie deleted from favorites", Toast.LENGTH_SHORT).show()
    }
}

