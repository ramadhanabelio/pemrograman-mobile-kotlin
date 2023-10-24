package com.ca1.thread1

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.ca1.thread1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    fun startThread(view: View) :Unit {
        for (i in 1..10) {
            Log.d(TAG, "startThread: $i")
            try {
                Thread.sleep(1000)
            } catch (ie: InterruptedException) {
                ie.printStackTrace()
            }
        }
    }
    
}