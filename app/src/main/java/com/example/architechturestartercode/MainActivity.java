package com.example.architechturestartercode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.architechturestartercode.presentation.allmovies.view.AllMoviesActivity;
import com.example.architechturestartercode.presentation.fav.view.FavActivity;


public class MainActivity extends AppCompatActivity {

    Button exitBtn;
    Button allMoviesBtn;
    Button favMoviesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        allMoviesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AllMoviesActivity.class));
            }
        });
        favMoviesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FavActivity.class));
            }
        });
    }

    private void initUI() {
        exitBtn = findViewById(R.id.btnExit);
        allMoviesBtn = findViewById(R.id.btnGetAllMovies);
        favMoviesBtn = findViewById(R.id.initUI);
    }

}