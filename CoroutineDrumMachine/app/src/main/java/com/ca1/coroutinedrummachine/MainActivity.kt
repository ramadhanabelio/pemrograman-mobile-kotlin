package com.ca1.coroutinedrummachine

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ca1.coroutinedrummachine.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var cymbal: MediaPlayer
    private lateinit var tom: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        cymbal = MediaPlayer.create(this, R.raw.cymbal)
        tom = MediaPlayer.create(this, R.raw.tom)

        binding.btnStart.setOnClickListener {
            runBlocking {
                launch { playBeasts("x-x-x-x-x-x-x-x-x-x-x-x-", R.raw.tom) }
                playBeasts("x-----x-----x-----x-----", R.raw.cymbal)
            }
        }
    }

    suspend fun playBeats(beats: String, fileId: Int){
        val parts = beats.split("x")
        var count = 0
        for(part in parts){
            count += part.length + 1
            if(part == ""){
                if(fileId == R.raw.cymbal)
                    cymbal.start()
                else
                    tom.start()
            }else{
                delay(1000 * (part.length + 1L))
                if(count < beats.length){
                    if(fileId == R.raw.cymbal)
                        cymbal.start()
                    else
                        tom.start()
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        cymbal.stop()
        tom.stop()
    }
}