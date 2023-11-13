package com.sidharth.chomu.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sidharth.chomu.databinding.FragmentSocialBinding

class SocialFragment : Fragment() {

    private lateinit var fragmentSocialBinding: FragmentSocialBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentSocialBinding = FragmentSocialBinding.inflate(inflater)
        return fragmentSocialBinding.root
    }

}