package com.sidharth.chomu.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.sidharth.chomu.databinding.FragmentEmailBinding

class EmailFragment : Fragment() {

    private lateinit var fragmentEmailBinding: FragmentEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentEmailBinding = FragmentEmailBinding.inflate(inflater)
        setupViewsAndListeners()
        return fragmentEmailBinding.root
    }

    private fun setupViewsAndListeners() {
        fragmentEmailBinding.topBar.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        fragmentEmailBinding.topBar.tvTitle.text = "Email"
        fragmentEmailBinding.bottomBar.btnGenerate.setOnClickListener {
            val action = EmailFragmentDirections.actionEmailFragmentToResultFragment("")
            findNavController().navigate(action)
        }
        fragmentEmailBinding.bottomBar.btnAdvance.setOnClickListener {
            val action = EmailFragmentDirections.actionEmailFragmentToAdvanceOptionsBottomSheet()
            findNavController().navigate(action)
        }
    }
}