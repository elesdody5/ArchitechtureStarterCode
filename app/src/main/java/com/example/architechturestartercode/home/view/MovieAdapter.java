package com.example.architechturestartercode.home.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.architechturestartercode.R;
import com.example.architechturestartercode.model.movie.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<Movie> movieList;
    private OnMovieClicked itemClickListener;

    public MovieAdapter(OnMovieClicked itemClickListener) {
        this.movieList = new ArrayList<>();
        this.itemClickListener = itemClickListener;
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
        private TextView movieIdTextView;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImageView = itemView.findViewById(R.id.movieImageView);
            movieTitleTextView = itemView.findViewById(R.id.movieTitleTextView);
            movieIdTextView = itemView.findViewById(R.id.movieIdTextView);
            itemView.setOnClickListener(view -> {
                int position = getBindingAdapterPosition();
                Movie movie = movieList.get(position);
                itemClickListener.onMovieClick(movie.getId());
            });
        }

        public void bind(Movie movie) {
            movieTitleTextView.setText(movie.getTitle());
            movieIdTextView.setText("ID: " + movie.getId());

             Glide.with(itemView.getContext())
                 .load(movie.getImageUrl())
                 .into(movieImageView);
        }
    }
}

