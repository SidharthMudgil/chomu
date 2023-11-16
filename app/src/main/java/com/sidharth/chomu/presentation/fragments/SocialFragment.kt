package com.sidharth.chomu.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.sidharth.chomu.databinding.FragmentSocialBinding

class SocialFragment : Fragment() {

    private lateinit var fragmentSocialBinding: FragmentSocialBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentSocialBinding = FragmentSocialBinding.inflate(inflater)
        setupViewsAndListeners()
        return fragmentSocialBinding.root
    }

    private fun setupViewsAndListeners() {
        fragmentSocialBinding.topBar.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        fragmentSocialBinding.topBar.tvTitle.text = "Social"
        fragmentSocialBinding.bottomBar.btnGenerate.setOnClickListener {
            val action = SocialFragmentDirections.actionSocialFragmentToResultFragment("")
            findNavController().navigate(action)
        }
        fragmentSocialBinding.bottomBar.btnAdvance.setOnClickListener {
            val action = SocialFragmentDirections.actionSocialFragmentToAdvanceOptionsBottomSheet()
            findNavController().navigate(action)
        }
    }
}