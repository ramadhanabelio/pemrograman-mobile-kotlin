package com.ca1.thread3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ca1.thread3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStartThread.setOnClickListener {
//            val runnable = ExampleThread(10);
            val runnable = ExampleRunnable(10);
            Thread(runnable).start()
        }
    }

//    fun startThread(view: View) :Unit {
//        val runnable = ExampleRunnable(10);
//        Thread(runnable).start()
//    }
}