package com.ca1.intent2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ca1.intent2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            val m_data = binding.editText.text.toString()
            val m_intent = Intent(this@MainActivity, SecondActivity::class.java)
            m_intent.putExtra("main_activity_data", m_data)
            startActivity(m_intent)
        }

    }
}