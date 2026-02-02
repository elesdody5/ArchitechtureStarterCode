package com.example.architechturestartercode.allmovies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.architechturestartercode.R;
import com.example.architechturestartercode.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<Movie> movieList;


    public MovieAdapter() {
        this.movieList = new ArrayList<>();
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return movieList != null ? movieList.size() : 0;
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        private ImageView movieImageView;
        private TextView movieTitleTextView;
        private TextView movieCategoryTextView;
        private Button addToFavoritesButton;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImageView = itemView.findViewById(R.id.iv_poster);
            movieTitleTextView = itemView.findViewById(R.id.tv_name);
            movieCategoryTextView = itemView.findViewById(R.id.tv_category);
            addToFavoritesButton = itemView.findViewById(R.id.btn_addToFav);
        }

        public void bind(Movie movie) {
            movieTitleTextView.setText(movie.getTitle());
            movieCategoryTextView.setText(movie.getLanguage());


        }
    }
}

