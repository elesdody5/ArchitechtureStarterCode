package com.example.architechturestartercode

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.architechturestartercode.presentation.allmovies.view.AllMoviesActivity
import com.example.architechturestartercode.presentation.favmovies.view.FavActivity

class MainActivity : AppCompatActivity() {

    private lateinit var exitBtn: Button
    private lateinit var allMoviesBtn: Button
    private lateinit var favMoviesBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
        exitBtn.setOnClickListener { finish() }
        allMoviesBtn.setOnClickListener {
            startActivity(Intent(this, AllMoviesActivity::class.java))
        }
        favMoviesBtn.setOnClickListener {
            startActivity(Intent(this, FavActivity::class.java))
        }
    }

    private fun initUI() {
        exitBtn = findViewById(R.id.btnExit)
        allMoviesBtn = findViewById(R.id.btnGetAllMovies)
        favMoviesBtn = findViewById(R.id.initUI)
    }
}

