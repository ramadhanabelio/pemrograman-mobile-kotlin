package com.ca1.thread2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ca1.thread2.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    fun  startThread(view: View) :Unit {
        val runnable = ExampleThread(10)
        Thread(runnable).start()
    }
}