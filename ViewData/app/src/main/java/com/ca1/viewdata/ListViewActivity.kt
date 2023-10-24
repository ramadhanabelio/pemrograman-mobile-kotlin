package com.ca1.viewdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.ca1.viewdata.databinding.ActivityListViewBinding
import java.util.*

class ListViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var dataArray: Array<String> =
            resources.getStringArray(R.array.jurusan)
        Arrays.sort(dataArray)
        var adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, dataArray)
        binding.listview.adapter = adapter
    }
}