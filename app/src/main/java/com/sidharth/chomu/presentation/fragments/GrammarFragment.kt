package com.sidharth.chomu.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sidharth.chomu.R
import com.sidharth.chomu.core.constant.Constants
import com.sidharth.chomu.databinding.FragmentGrammarBinding

class GrammarFragment : Fragment() {

    private lateinit var fragmentGrammarBinding: FragmentGrammarBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentGrammarBinding = FragmentGrammarBinding.inflate(inflater)
        setupViewsAndListeners()
        return fragmentGrammarBinding.root
    }

    private fun setupViewsAndListeners() {
        fragmentGrammarBinding.topBar.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        fragmentGrammarBinding.topBar.tvTitle.text = getString(R.string.grammar)
        fragmentGrammarBinding.bottomBar.btnGenerate.setOnClickListener {
            if (isInputValid()) {
                val action = GrammarFragmentDirections.actionGrammarFragmentToResultFragment(
                    prompt = fragmentGrammarBinding.etInput.text.toString(),
                    command = Constants.COMMAND_GRAMMAR
                )
                findNavController().navigate(action)
            }
        }
        fragmentGrammarBinding.bottomBar.btnAdvance.setOnClickListener {
            val action =
                GrammarFragmentDirections.actionGrammarFragmentToAdvanceOptionsBottomSheet()
            findNavController().navigate(action)
        }
    }

    private fun isInputValid(): Boolean {
        return fragmentGrammarBinding.etInput.text.isNullOrBlank().not()
    }
}