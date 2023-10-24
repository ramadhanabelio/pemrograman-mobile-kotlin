package com.ca1.eventhandling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ca1.eventhandling.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnDisplayMessage.setOnClickListener{
            Toast.makeText(applicationContext, "Hello World", Toast.LENGTH_LONG).show()
        }
        binding.btnDisplayMessage.setOnLongClickListener{
            Snackbar.make(binding.root, "Long Clisk", Snackbar.LENGTH_LONG).show()
            true
        }
    }
    
}