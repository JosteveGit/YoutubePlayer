package com.example.youtubeplayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hi.setOnClickListener {
            startActivity(Intent(this, YoutubePlayerActivity::class.java).apply {
                putExtra("url", text_.text.toString())
            })

        }

    }
}