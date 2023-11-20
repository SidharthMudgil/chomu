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
import com.sidharth.chomu.domain.model.Options
import com.sidharth.chomu.presentation.component.AdvanceOptionsBottomSheet

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findNavController().currentBackStackEntry
            ?.savedStateHandle
            ?.getLiveData<Options>(AdvanceOptionsBottomSheet.KEY_OPTIONS)
            ?.observe(viewLifecycleOwner) { options = it }
    }

    private fun setupViewsAndListeners() {
        fragmentSummaryBinding.topBar.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        fragmentSummaryBinding.topBar.tvTitle.text = getString(R.string.summary)
        fragmentSummaryBinding.bottomBar.btnGenerate.setOnClickListener {
            if (isInputValid()) {
                val action = SummaryFragmentDirections.actionSummaryFragmentToResultFragment(
                    prompt = getPrompt(),
                    command = Constants.COMMAND_SUMMARY
                )
                findNavController().navigate(action)
            }
        }
        fragmentSummaryBinding.bottomBar.btnAdvance.setOnClickListener {
            val action =
                SummaryFragmentDirections.actionSummaryFragmentToAdvanceOptionsBottomSheet()
            findNavController().navigate(action)
        }
    }

    private fun getPrompt(): String {
        return "${fragmentSummaryBinding.etInput.text}" +
                "Formality: ${options.formality}" +
                "Tone: ${options.tone}" +
                "Length: ${options.length}" +
                "Style: ${options.style}"
    }

    private fun isInputValid(): Boolean {
        return fragmentSummaryBinding.etInput.text.isNullOrBlank().not()
    }

    companion object {
        private var options = Options(
            formality = "Neutral",
            tone = "Cooperative",
            length = "Medium",
            style = "None"
        )
    }
}