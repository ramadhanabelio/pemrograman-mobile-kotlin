package com.ca1.runonuithread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ca1.runonuithread.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            Thread { killSomeTime() }.start()
        }
    }

    private fun killSomeTime() {
        for (i in 1 .. 20) {
            runOnUiThread( Runnable {
                binding.tvCounter.text = i.toString()
            })
            println("i:$i")
            Thread.sleep(1000)
        }
    }
}