package com.sidharth.chomu.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
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
        fragmentGrammarBinding.topBar.tvTitle.text = "Grammar"
        fragmentGrammarBinding.bottomBar.btnGenerate.setOnClickListener {
            val action = GrammarFragmentDirections.actionGrammarFragmentToResultFragment("")
            findNavController().navigate(action)
        }
    }
}