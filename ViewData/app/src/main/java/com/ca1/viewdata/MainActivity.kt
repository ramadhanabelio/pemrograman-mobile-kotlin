package com.ca1.viewdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import com.ca1.viewdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnlistview.setOnClickListener {
            actionPindah(ListViewActivity())
        }
        binding.btnrecylerview.setOnClickListener{
            actionPindah(RecylerActivity())
        }
    }

    private fun actionPindah(simpleActivity: Any) {
        startActivity(Intent(applicationContext, simpleActivity::class.java))
    }
}
