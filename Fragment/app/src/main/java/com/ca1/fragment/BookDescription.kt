package com.ca1.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ca1.fragment.databinding.BookDescriptionBinding

class BookDescription : Fragment() {

    private var _binding: BookDescriptionBinding? = null
    private val binding get() = _binding!!
    private lateinit var arrbookdesc: Array<String>
    var bookindex = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        arrbookdesc = resources.getStringArray(R.array.bookdescriptions)
        _binding = BookDescriptionBinding.inflate(inflater, container, false)
        bookindex = if(savedInstanceState?.getInt("bookindex") == null) 0
        else { savedInstanceState.getInt("bookindex")}
        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("bookindex", bookindex)
    }

    fun changeDescription(index: Int) {
        bookindex = index
        binding.txtdescription.text = arrbookdesc[bookindex]
        println("BOOK INDEX = $bookindex")
        println(arrbookdesc[bookindex])
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        changeDescription(bookindex)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}