package com.sidharth.chomu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sidharth.chomu.databinding.FragmentSummaryBinding

class SummaryFragment : Fragment() {

    private lateinit var fragmentSummaryBinding: FragmentSummaryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentSummaryBinding = FragmentSummaryBinding.inflate(inflater)
        return fragmentSummaryBinding.root
    }
}