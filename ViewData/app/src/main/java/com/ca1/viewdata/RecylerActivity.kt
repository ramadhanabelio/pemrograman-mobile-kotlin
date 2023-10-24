package com.ca1.viewdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ca1.viewdata.databinding.ActivityRecylerBinding

class RecylerActivity : AppCompatActivity() {

    //deklarasi
    var dataBuah =
        arrayOf("alpukat","durian","jambuair","manggis","strawberry")

    var dataGambar= arrayOf(
        R.drawable.alpukat,
        R.drawable.durian,
        R.drawable.jambuair,
        R.drawable.manggis,
        R.drawable.strawberry)

    private lateinit var binding: ActivityRecylerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecylerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //custom adapter, nnt dibuatkan constructor nnti akan di buat contrut di custom adpater
        var adapter = CustomAdapter(this, dataBuah, dataGambar)

        //buat layout manaager
        var liner = LinearLayoutManager(applicationContext)

        //manggil listnya
        binding.recylerview.adapter = adapter
        binding.recylerview.layoutManager = liner
    }
}