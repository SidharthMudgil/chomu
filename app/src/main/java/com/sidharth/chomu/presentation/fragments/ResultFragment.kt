package com.sidharth.chomu.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sidharth.chomu.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private lateinit var fragmentResultBinding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentResultBinding = FragmentResultBinding.inflate(inflater)
        return fragmentResultBinding.root
    }

}