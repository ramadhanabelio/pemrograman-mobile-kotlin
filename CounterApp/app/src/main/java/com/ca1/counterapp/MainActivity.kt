package com.ca1.counterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ca1.counterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewAngka.text = "0"
//        binding.buttonTambahAngka.text = "Add Number"

        binding.buttonTambahAngka.setOnClickListener { tambahAngka()}
        binding.buttonKurangAngka.setOnClickListener { kurangAngka() }
        binding.buttonResetAngka.setOnClickListener { resetAngka() }
    }

    fun tambahAngka() {
        val currentValue = binding.textViewAngka.text.toString().toInt()
        val nextValue = currentValue + 1
        binding.textViewAngka.text = nextValue.toString()
    }

    fun resetAngka() {
        binding.textViewAngka.text = "0"
    }

    fun kurangAngka() {
        val currentValue = binding.textViewAngka.text.toString().toInt()
        val nextValue = currentValue - 1
        binding.textViewAngka.text = nextValue.toString()
    }
}