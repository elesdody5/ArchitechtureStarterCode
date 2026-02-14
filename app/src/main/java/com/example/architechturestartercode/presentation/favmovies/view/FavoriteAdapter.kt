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

class FavoriteAdapter(private val listener: OnFavoriteClickListener) :
    RecyclerView.Adapter<FavoriteAdapter.ViewHolder?>() {
    private var movies: MutableList<Movie>

    init {
        this.movies = ArrayList<Movie>()
        Log.i(TAG, "FavoriteAdapter: ")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.getContext())
        val v = layoutInflater.inflate(R.layout.item_favorite, parent, false)
        val viewHolder: ViewHolder = ViewHolder(v)
        Log.i(TAG, "=========== onCreateViewHolder ===========")
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies.get(position)
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun setList(updatedMovies: MutableList<Movie>) {
        this.movies = updatedMovies
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var favMovieImg: ImageView
        var favMovieName: TextView
        var favMovieCategory: TextView
        var removeFavBtn: Button
        var layout: ConstraintLayout?

        init {
            layout = itemView.findViewById<ConstraintLayout?>(R.id.constraint_fav_movie)
            favMovieName = itemView.findViewById<TextView>(R.id.tv_fav_name)
            favMovieCategory = itemView.findViewById<TextView>(R.id.tv_fav_category)
            removeFavBtn = itemView.findViewById<Button>(R.id.btn_fav_delete)
            favMovieImg = itemView.findViewById<ImageView>(R.id.iv_fav_poster)
        }

        fun bind(movie: Movie) {
            favMovieCategory.setText(movie.title)
            favMovieName.setText(movie.language)
            Glide.with(itemView)
                .load(movie.getPoster())
                .into(favMovieImg)
            removeFavBtn.setOnClickListener(object : View.OnClickListener {
                override fun onClick(view: View?) {
                    listener.onClick(movie)
                }
            })
        }
    }

    companion object {
        const val TAG: String = "FavoriteAdapter"
    }
}
