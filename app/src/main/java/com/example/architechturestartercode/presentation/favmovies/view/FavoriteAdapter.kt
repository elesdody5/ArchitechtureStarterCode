package com.example.architechturestartercode.presentation.favmovies.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.architechturestartercode.R
import com.example.architechturestartercode.data.movie.model.Movie

class FavoriteAdapter(
    private val listener: OnFavoriteClickListener
) : RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {

    private var movies: List<Movie> = ArrayList()

    companion object {
        const val TAG = "FavoriteAdapter"
    }

    init {
        Log.i(TAG, "FavoriteAdapter: ")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val v = layoutInflater.inflate(R.layout.item_favorite, parent, false)
        Log.i(TAG, "=========== onCreateViewHolder ===========")
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = movies.size

    fun setList(updatedMovies: List<Movie>) {
        this.movies = updatedMovies
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val favMovieImg: ImageView = itemView.findViewById(R.id.iv_fav_poster)
        private val favMovieName: TextView = itemView.findViewById(R.id.tv_fav_name)
        private val favMovieCategory: TextView = itemView.findViewById(R.id.tv_fav_category)
        private val removeFavBtn: Button = itemView.findViewById(R.id.btn_fav_delete)
        private val layout: ConstraintLayout = itemView.findViewById(R.id.constraint_fav_movie)

        fun bind(movie: Movie) {
            favMovieCategory.text = movie.title
            favMovieName.text = movie.language
            Glide.with(itemView)
                .load(movie.fullPosterUrl)
                .centerCrop()
                .into(favMovieImg)
            removeFavBtn.setOnClickListener {
                listener.deleteFromFav(movie)
            }
        }
    }
}

