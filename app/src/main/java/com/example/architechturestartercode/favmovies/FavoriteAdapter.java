package com.example.architechturestartercode.favmovies;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.architechturestartercode.R;
import com.example.architechturestartercode.model.Movie;

import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {
    private List<Movie> movies;
    private OnFavoriteClickListener listener;
    public static final String TAG = "FavoriteAdapter";

    public FavoriteAdapter(OnFavoriteClickListener _listener) {
        this.movies = new java.util.ArrayList<>();
        this.listener = _listener;
        Log.i(TAG, "FavoriteAdapter: ");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.item_favorite, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        Log.i(TAG, "=========== onCreateViewHolder ===========");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setList(List<Movie> updatedMovies) {
        this.movies = updatedMovies;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView favMovieImg;
        TextView favMovieName;
        TextView favMovieCategory;
        Button removeFavBtn;
        ConstraintLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.constraint_fav_movie);
            favMovieName = itemView.findViewById(R.id.tv_fav_name);
            favMovieCategory = itemView.findViewById(R.id.tv_fav_category);
            removeFavBtn = itemView.findViewById(R.id.btn_fav_delete);
            favMovieImg = itemView.findViewById(R.id.iv_fav_poster);
        }

        void bind(Movie movie) {
            favMovieCategory.setText(movie.getTitle());
            favMovieName.setText(movie.getLanguage());
            Glide.with(itemView)
                    .load(movie.getPosterUrl())
                    .centerCrop()
                    .into(favMovieImg);
            removeFavBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.deleteFromFav(movie);
                }
            });
        }
    }
}
