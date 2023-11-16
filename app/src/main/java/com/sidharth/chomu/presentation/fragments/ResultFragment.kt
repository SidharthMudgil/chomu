package com.sidharth.chomu.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.sidharth.chomu.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private lateinit var fragmentResultBinding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentResultBinding = FragmentResultBinding.inflate(inflater)
        setupViewsAndListeners()
        return fragmentResultBinding.root
    }

    private fun setupViewsAndListeners() {
        fragmentResultBinding.topBar.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        fragmentResultBinding.topBar.tvTitle.text = "Result"
    }
}