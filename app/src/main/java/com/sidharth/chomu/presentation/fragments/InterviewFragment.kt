package com.sidharth.chomu.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sidharth.chomu.databinding.FragmentInterviewBinding

class InterviewFragment : Fragment() {

    private lateinit var fragmentInterviewBinding: FragmentInterviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentInterviewBinding = FragmentInterviewBinding.inflate(inflater)
        return fragmentInterviewBinding.root
    }

}