package com.sidharth.chomu.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sidharth.chomu.R
import com.sidharth.chomu.core.constant.Constants
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
        fragmentSummaryBinding.topBar.tvTitle.text = getString(R.string.summary)
        fragmentSummaryBinding.bottomBar.btnGenerate.setOnClickListener {
            if (isInputValid()) {
                val action = SummaryFragmentDirections.actionSummaryFragmentToResultFragment(
                    prompt = fragmentSummaryBinding.etInput.text.toString(),
                    command = Constants.COMMAND_SUMMARY
                )
                findNavController().navigate(action)
            }
        }
        fragmentSummaryBinding.bottomBar.btnAdvance.setOnClickListener {
            val action = SummaryFragmentDirections.actionSummaryFragmentToAdvanceOptionsBottomSheet()
            findNavController().navigate(action)
        }
    }

    private fun isInputValid(): Boolean {
        return fragmentSummaryBinding.etInput.text.isNullOrBlank().not()
    }
}