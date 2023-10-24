package com.ca1.viewdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ca1.viewdata.databinding.ActivityDetailBuahBinding

class DetailBuahActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBuahBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBuahBinding.inflate(layoutInflater)
        setContentView(binding.root)

            //membuat variabel dan di tangkap data dri intent
            var tangkap = intent.getStringExtra("txt")
            var tangkap2 = intent.getIntExtra("img",0)

            //menangkap data intent dan di set ke layout
            binding.detailtxt.text = tangkap
            binding.imgdetail.setImageResource(tangkap2)
    }
}