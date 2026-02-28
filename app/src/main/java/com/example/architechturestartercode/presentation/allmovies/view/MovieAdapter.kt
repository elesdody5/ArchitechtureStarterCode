package com.example.architechturestartercode.presentation.allmovies.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.architechturestartercode.R
import com.example.architechturestartercode.data.movie.model.Movie

class MovieAdapter(
    private val onMovieClicked: OnMovieClicked
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var movieList: List<Movie> = ArrayList()

    fun setMovieList(movieList: List<Movie>) {
        this.movieList = movieList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = movieList.size

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val movieImageView: ImageView = itemView.findViewById(R.id.iv_poster)
        private val movieTitleTextView: TextView = itemView.findViewById(R.id.tv_name)
        private val movieCategoryTextView: TextView = itemView.findViewById(R.id.tv_category)
        private val addToFavoritesButton: Button = itemView.findViewById(R.id.btn_addToFav)

        fun bind(movie: Movie) {
            movieTitleTextView.text = movie.title
            movieCategoryTextView.text = movie.language
            addToFavoritesButton.setOnClickListener {
                onMovieClicked.addToFav(movie)
            }
            Glide.with(itemView)
                .load(movie.fullPosterUrl)
                .centerCrop()
                .into(movieImageView)
        }
    }
}

