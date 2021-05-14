package com.example.jpsubmission1.splash.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.jpsubmission1.R
import com.example.jpsubmission1.databinding.FragmentScreen2Binding

class screen2 : Fragment() {
    private var _binding: FragmentScreen2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentScreen2Binding.inflate(inflater, container, false)

        val pager = activity?.findViewById<ViewPager2>(R.id.splashPager)
        binding.btnToScreen3.setOnClickListener {
            pager?.currentItem = 2
        }

        return binding.root
    }

}