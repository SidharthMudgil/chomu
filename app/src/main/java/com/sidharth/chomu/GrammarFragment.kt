package com.sidharth.chomu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sidharth.chomu.databinding.FragmentGrammarBinding

class GrammarFragment : Fragment() {

    private lateinit var fragmentGrammarBinding: FragmentGrammarBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentGrammarBinding = FragmentGrammarBinding.inflate(inflater)
        return fragmentGrammarBinding.root
    }

}