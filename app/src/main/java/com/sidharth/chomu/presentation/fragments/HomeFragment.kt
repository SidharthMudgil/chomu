package com.sidharth.chomu.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sidharth.chomu.core.constant.Constants
import com.sidharth.chomu.core.enums.Assistants
import com.sidharth.chomu.databinding.FragmentHomeBinding
import com.sidharth.chomu.presentation.adapter.AssistantAdapter
import com.sidharth.chomu.presentation.callback.OnAssistantClickCallback

class HomeFragment : Fragment(), OnAssistantClickCallback {

    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater)
        setupRecyclerView()
        setupClickListeners()
        return fragmentHomeBinding.root
    }

    private fun setupClickListeners() {
        fragmentHomeBinding.searchView.btnSend.setOnClickListener {
            if (fragmentHomeBinding.searchView.etInput.text.isNullOrBlank().not()) {
                val action = HomeFragmentDirections.actionHomeFragmentToChatFragment(
                    fragmentHomeBinding.searchView.etInput.text.toString()
                )
                findNavController().navigate(action)
            }
        }
    }

    private fun setupRecyclerView() {
        fragmentHomeBinding.rvCategories.apply {
            adapter = AssistantAdapter(
                assistants = Constants.ASSISTANTS,
                onAssistantClickCallback = this@HomeFragment,
            )
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onAssistantClick(id: Int) {
        val action = when (id) {
            Assistants.EMAIL.ordinal -> {
                HomeFragmentDirections.actionHomeFragmentToEmailFragment()
            }

            Assistants.WRITING.ordinal -> {
                HomeFragmentDirections.actionHomeFragmentToWritingFragment()
            }

            Assistants.SUMMARY.ordinal -> {
                HomeFragmentDirections.actionHomeFragmentToSummaryFragment()
            }

            Assistants.GRAMMAR.ordinal -> {
                HomeFragmentDirections.actionHomeFragmentToGrammarFragment()
            }

            Assistants.SOCIAL.ordinal -> {
                HomeFragmentDirections.actionHomeFragmentToSocialFragment()
            }

            Assistants.INTERVIEW.ordinal -> {
                HomeFragmentDirections.actionHomeFragmentToInterviewFragment()
            }

            else -> null
        }
        findNavController().navigate(action!!)
    }

}