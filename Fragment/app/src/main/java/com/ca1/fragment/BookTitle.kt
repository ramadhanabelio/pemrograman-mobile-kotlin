package com.ca1.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ca1.fragment.databinding.BookTitlesBinding

class BookTitle: Fragment(), View.OnClickListener {

    private var _binding: BookTitlesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BookTitlesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rlas3.setOnClickListener(this)
        binding.rlas3kotlin.setOnClickListener(this)
        binding.rminandroid.setOnClickListener(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(p0: View?) {
        var index = 0
        when(p0?.id) {
            R.id.rlas3 -> {
                index = 0
            }
            R.id.rlas3kotlin -> {
                index = 1
            }
            R.id.rminandroid -> {
                index = 2
            }
        }
        val activity = getActivity()
        if (activity is Coordinator) {
            activity.onBookChanged(index)
        }
    }

}