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
import com.example.architechturestartercode.data.movie.datasource.remote.model.RemoteMovie

class FavoriteAdapter(
    private val listener: OnFavoriteClickListener
) : RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {

    private var remoteMovies: List<RemoteMovie> = ArrayList()

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
        val movie = remoteMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = remoteMovies.size

    fun setList(updatedRemoteMovies: List<RemoteMovie>) {
        this.remoteMovies = updatedRemoteMovies
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val favMovieImg: ImageView = itemView.findViewById(R.id.iv_fav_poster)
        private val favMovieName: TextView = itemView.findViewById(R.id.tv_fav_name)
        private val favMovieCategory: TextView = itemView.findViewById(R.id.tv_fav_category)
        private val removeFavBtn: Button = itemView.findViewById(R.id.btn_fav_delete)
        private val layout: ConstraintLayout = itemView.findViewById(R.id.constraint_fav_movie)

        fun bind(remoteMovie: RemoteMovie) {
            favMovieCategory.text = remoteMovie.title
            favMovieName.text = remoteMovie.language
            Glide.with(itemView)
                .load(remoteMovie.fullPosterUrl)
                .centerCrop()
                .into(favMovieImg)
            removeFavBtn.setOnClickListener {
                listener.deleteFromFav(remoteMovie)
            }
        }
    }
}

