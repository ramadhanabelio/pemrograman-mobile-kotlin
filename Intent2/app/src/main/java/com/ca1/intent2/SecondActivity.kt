package com.ca1.intent2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ca1.intent2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val m_data = intent.getStringExtra("main_activity_data")
        binding.textView.text = m_data
    }

}