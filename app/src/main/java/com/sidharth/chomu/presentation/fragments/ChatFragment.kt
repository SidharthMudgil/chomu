package com.sidharth.chomu.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sidharth.chomu.databinding.FragmentChatBinding

class ChatFragment : Fragment() {
    private lateinit var fragmentChatBinding: FragmentChatBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentChatBinding = FragmentChatBinding.inflate(inflater)
        return fragmentChatBinding.root
    }

}