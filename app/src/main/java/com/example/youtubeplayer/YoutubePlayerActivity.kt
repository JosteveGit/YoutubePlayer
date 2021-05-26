package com.example.youtubeplayer

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener
import kotlinx.android.synthetic.main.activity_youtube_player.*

class YoutubePlayerActivity : YouTubeBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube_player)

        val url = intent.getStringExtra("url")

        var hold: String = url!!
        //"https://www.youtube.com/watch?v=U2LuTUP_OsQ&list=RDU2LuTUP_OsQ&start_radio=1"
        val indexOfAnd = hold.indexOf("&")
        if (indexOfAnd != -1) {
            hold = hold.substring(0, indexOfAnd)
        }
        val indexOfEquals = hold.indexOf("=")
        hold = hold.substring(indexOfEquals + 1)
        Log.d("Hold", hold)


        val a: OnInitializedListener = object : OnInitializedListener {
            override fun onInitializationSuccess(
                provider: YouTubePlayer.Provider,
                youTubePlayer: YouTubePlayer,
                b: Boolean
            ) {
                youTubePlayer.loadVideo(hold)
            }

            override fun onInitializationFailure(
                provider: YouTubePlayer.Provider,
                youTubeInitializationResult: YouTubeInitializationResult
            ) {
                Log.d("Error", "Error")
            }
        }

        view.initialize(YoutubeConfig.apiKey, a)


    }
}