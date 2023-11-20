package com.sidharth.chomu.presentation.fragments

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sidharth.chomu.R
import com.sidharth.chomu.databinding.FragmentResultBinding
import com.sidharth.chomu.domain.model.PromptResult
import com.sidharth.chomu.presentation.viewmodel.ResultViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ResultFragment : Fragment() {

    private val resultViewModel: ResultViewModel by viewModels()
    private val resultFragmentArgs: ResultFragmentArgs by navArgs()
    private lateinit var fragmentResultBinding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentResultBinding = FragmentResultBinding.inflate(inflater)
        setupViewsAndListeners()
        observeResultData()
        fetchResult()
        return fragmentResultBinding.root
    }

    private fun fetchResult() {
        lifecycleScope.launch {
            resultViewModel.fetchResult(
                prompt = resultFragmentArgs.prompt,
                command = resultFragmentArgs.command,
            )
        }
    }

    private fun observeResultData() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                resultViewModel.result.collect {
                    when (it) {
                        is PromptResult.Error -> {
                            fragmentResultBinding.tvResult.text = getString(R.string.result_error)
                        }

                        PromptResult.Loading -> {
                            fragmentResultBinding.tvResult.text = getString(R.string.typing)
                        }

                        is PromptResult.Success -> {
                            fragmentResultBinding.tvResult.text = it.data
                        }
                    }
                }
            }
        }
    }

    private fun setupViewsAndListeners() {
        fragmentResultBinding.bottomBar.btnAdvance.visibility = View.GONE
        fragmentResultBinding.bottomBar.btnGenerate.text = getString(R.string.re_generate)
        fragmentResultBinding.tvResult.movementMethod = ScrollingMovementMethod()
        fragmentResultBinding.topBar.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        fragmentResultBinding.topBar.tvTitle.text = getString(R.string.result)
        fragmentResultBinding.bottomBar.btnGenerate.setOnClickListener { fetchResult() }
    }
}