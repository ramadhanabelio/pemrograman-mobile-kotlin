package com.ca1.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ca1.sharedpreferences.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnloaddata.setOnClickListener {
            val filename = "$packageName TESTFILE"
            val pref = getSharedPreferences(filename, Context.MODE_PRIVATE)
            val mlastname = pref.getString("lastname", "")
            val mfirstname = pref.getString("firstname", "")
            binding.txtoutput.text = "$mfirstname $mlastname "
        }
    }

    override fun onResume() {
        super.onResume()
        binding.txtoutput.text = "Click LOAD DATA"
    }
}