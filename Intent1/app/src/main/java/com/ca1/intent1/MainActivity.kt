package com.ca1.intent1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ca1.intent1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnToSecondActivity.setOnClickListener {
            val m_intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(m_intent)
        }
    }

}