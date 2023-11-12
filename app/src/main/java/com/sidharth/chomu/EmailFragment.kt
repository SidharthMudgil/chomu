package com.sidharth.chomu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sidharth.chomu.databinding.FragmentEmailBinding

class EmailFragment : Fragment() {

    private lateinit var fragmentEmailBinding: FragmentEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentEmailBinding = FragmentEmailBinding.inflate(inflater)
        return fragmentEmailBinding.root
    }

}