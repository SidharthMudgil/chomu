package com.sidharth.chomu.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.sidharth.chomu.databinding.FragmentWritingBinding

class WritingFragment : Fragment() {

    private lateinit var fragmentWritingBinding: FragmentWritingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentWritingBinding = FragmentWritingBinding.inflate(inflater)
        setupViewsAndListeners()
        return fragmentWritingBinding.root
    }

    private fun setupViewsAndListeners() {
        fragmentWritingBinding.topBar.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        fragmentWritingBinding.topBar.tvTitle.text = "Writing"

        fragmentWritingBinding.bottomBar.btnGenerate.setOnClickListener {
            val action = WritingFragmentDirections.actionWritingFragmentToResultFragment("")
            findNavController().navigate(action)
        }
    }
}