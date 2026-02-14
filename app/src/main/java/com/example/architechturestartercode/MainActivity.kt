package com.example.architechturestartercode

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.architechturestartercode.presentation.allmovies.view.AllMoviesActivity
import com.example.architechturestartercode.presentation.favmovies.view.FavMoviesActivity

class MainActivity : AppCompatActivity() {
    var exitBtn: Button? = null
    var allMoviesBtn: Button? = null
    var favMoviesBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
        exitBtn!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                finish()
            }
        })
        allMoviesBtn!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                startActivity(Intent(this@MainActivity, AllMoviesActivity::class.java))
            }
        })
        favMoviesBtn!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                startActivity(Intent(this@MainActivity, FavMoviesActivity::class.java))
            }
        })
    }

    private fun initUI() {
        exitBtn = findViewById<Button>(R.id.btnExit)
        allMoviesBtn = findViewById<Button>(R.id.btnGetAllMovies)
        favMoviesBtn = findViewById<Button>(R.id.initUI)
    }
}