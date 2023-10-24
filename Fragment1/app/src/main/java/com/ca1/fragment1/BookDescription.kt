package com.ca1.fragment1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.book_description.*

class BookDescription : Fragment() {
    lateinit var arrbookdesc: Array<String>
    var bookindex = 0
    override fun onCreateView(
        inflater: LayoutInflater, container:
        ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.book_description, container,
            false)
        arrbookdesc = resources.getStringArray(R.array.bookdescriptions)
        return v
    }
    fun changeDescription(index: Int): Unit {
        bookindex = index
        txtdescription?.setText(arrbookdesc[bookindex])
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        changeDescription(bookindex)
    }
}