package com.example.architechturestartercode.presentation.allmovies.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.architechturestartercode.R
import com.example.architechturestartercode.data.movie.model.Movie
import com.example.architechturestartercode.presentation.allmovies.presenter.AllMoviesPresenter
import com.example.architechturestartercode.presentation.allmovies.presenter.AllMoviesPresenterImp

class AllMoviesActivity : AppCompatActivity(), OnMovieClicked, AllMoviesView {
    private lateinit var moviesRecyclerView: RecyclerView
    private lateinit var adapter: MovieAdapter
    private lateinit var presenter: AllMoviesPresenter
    private lateinit var progressBar: ProgressBar
    private lateinit var errorTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_movies)
        moviesRecyclerView = findViewById(R.id.rv_movies)
        progressBar = findViewById(R.id.progress_circular)
        errorTextView = findViewById(R.id.error_tv)
        progressBar.visibility = View.VISIBLE
        errorTextView.visibility = View.GONE
        adapter = MovieAdapter(this)
        moviesRecyclerView.adapter = adapter
        presenter = AllMoviesPresenterImp(applicationContext, this)
        presenter.getAllMovies()
    }

    override fun addToFav(movie: Movie) {
        presenter.addToFav(movie)
    }

    fun openMovieDetails(movie: Movie) {
        presenter.openMovieDetails(movie)
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun setMovies(movies: List<Movie>) {
        adapter.setMovieList(movies)
    }

    override fun showError(errorMessage: String) {
        errorTextView.visibility = View.VISIBLE
        errorTextView.text = errorMessage
    }

    override fun onAddToFavSuccess() {
        Toast.makeText(this, "Added to Favorites", Toast.LENGTH_SHORT).show()
    }

    override fun navigateToDetails(movie: Movie) {
        startActivity(Intent())
    }
}

