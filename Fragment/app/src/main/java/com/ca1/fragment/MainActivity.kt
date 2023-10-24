package com.ca1.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ca1.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Coordinator {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onBookChanged(index:Int) {
        val frag = supportFragmentManager.findFragmentById(R.id.fragmentbookdescription)
        if (frag is BookDescription) {
            frag.changeDescription(index)
        }
    }

}