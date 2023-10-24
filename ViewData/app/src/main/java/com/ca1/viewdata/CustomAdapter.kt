package com.ca1.viewdata

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter : RecyclerView.Adapter<CustomAdapter.Myholder> {
    private var c: Activity? = null
    private var databuah: Array<String>? = null
    private var datagambar: Array<Int>? = null
    constructor(recylerActivity: RecylerActivity, dataBuah: Array<String>,
                dataGambar: Array<Int>) {
        c = recylerActivity
        databuah = dataBuah
        datagambar = dataGambar
    }

    // Set data ke recylerview
    override fun onBindViewHolder(holder: Myholder, position: Int) {

        // manggil dan set data
        holder.txt?.text = databuah?.get(position)
        holder.img?.setImageResource(datagambar?.get(position)!!)
        holder.img?.setOnClickListener {
            var intent = Intent(c, DetailBuahActivity::class.java)
            intent.putExtra("txt", databuah?.get(position))
            intent.putExtra("img", datagambar?.get(position))
            c?.startActivity(intent)
        }
    }

    //mencreate pada layout list item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            Myholder {
        var view = LayoutInflater.from(c).inflate(R.layout.list_item, parent, false)
        return Myholder(view)
    }

    //tampilkan data
    override fun getItemCount(): Int {

    //return data gmbr
        return databuah?.size!!
    }

    //deklarasi id pada customAdapter, id yang ada pada list_item
    class Myholder(itemView: View?) : RecyclerView.ViewHolder(itemView!!)
    {
        var txt: TextView? = itemView?.findViewById(R.id.namabuah)
        var img: ImageView? = itemView?.findViewById(R.id.imglsitietm)
    }
}