package com.ca1.mediaplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ca1.mediaplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var mediaPlayer: MediaPlayer? = null
    private var pause = false
    private var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    fun startMedia(view: View?) {
        if (pause) { //initially, pause is set to false
            mediaPlayer?.seekTo(position)
            mediaPlayer?.start()
            pause = false
    // playing audio when in paused state
        } else {
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(applicationContext,
                    R.raw.ring)
                mediaPlayer?.setOnCompletionListener { stopPlayer() }
            }
            mediaPlayer?.start()
    // playing audio when in prepared state
        }
    }

    fun pauseMedia(view: View?) {
        if(mediaPlayer != null){
            position = mediaPlayer!!.getCurrentPosition()
            mediaPlayer?.pause()
            pause = true
        }
    }

    fun stopMedia(view: View?) {
        stopPlayer()
    }

    private fun stopPlayer() {
        if(mediaPlayer != null){
            pause = false
            position = 0
            mediaPlayer?.release()
            mediaPlayer = null;
            Toast.makeText(this, "Media Player Released!",
                Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStop() {
        super.onStop()
        stopPlayer()
    }
}