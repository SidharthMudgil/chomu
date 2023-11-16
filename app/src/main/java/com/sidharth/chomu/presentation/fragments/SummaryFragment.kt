package com.sidharth.chomu.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.sidharth.chomu.databinding.FragmentSummaryBinding

class SummaryFragment : Fragment() {

    private lateinit var fragmentSummaryBinding: FragmentSummaryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentSummaryBinding = FragmentSummaryBinding.inflate(inflater)
        setupViewsAndListeners()
        return fragmentSummaryBinding.root
    }

    private fun setupViewsAndListeners() {
        fragmentSummaryBinding.topBar.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        fragmentSummaryBinding.topBar.tvTitle.text = "Summary"
        fragmentSummaryBinding.bottomBar.btnGenerate.setOnClickListener {
            val action = SummaryFragmentDirections.actionSummaryFragmentToResultFragment("")
            findNavController().navigate(action)
        }
        fragmentSummaryBinding.bottomBar.btnAdvance.setOnClickListener {
            val action = SummaryFragmentDirections.actionSummaryFragmentToAdvanceOptionsBottomSheet()
            findNavController().navigate(action)
        }
    }
}