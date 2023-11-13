package com.sidharth.chomu.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sidharth.chomu.databinding.FragmentWritingBinding

class WritingFragment : Fragment() {

    private lateinit var fragmentWritingBinding: FragmentWritingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentWritingBinding = FragmentWritingBinding.inflate(inflater)
        return fragmentWritingBinding.root
    }
}