package com.sidharth.chomu.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sidharth.chomu.R
import com.sidharth.chomu.core.constant.Constants
import com.sidharth.chomu.databinding.FragmentInterviewBinding

class InterviewFragment : Fragment() {

    private lateinit var fragmentInterviewBinding: FragmentInterviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentInterviewBinding = FragmentInterviewBinding.inflate(inflater)
        setupViewsAndListeners()
        return fragmentInterviewBinding.root
    }

    private fun setupViewsAndListeners() {
        fragmentInterviewBinding.bottomBar.btnAdvance.visibility = View.GONE
        fragmentInterviewBinding.topBar.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        fragmentInterviewBinding.topBar.tvTitle.text = getString(R.string.interview)
        fragmentInterviewBinding.bottomBar.btnGenerate.setOnClickListener {
            if (isInputValid()) {
                val action = InterviewFragmentDirections.actionInterviewFragmentToResultFragment(
                    prompt = "job role: ${fragmentInterviewBinding.etJobRole.text}" +
                            "Experience: ${getExperience()}" +
                            "Focus Point: ${getFocusPoint()}" +
                            "Topics: ${getTopics()}",
                    command = Constants.COMMAND_INTERVIEW
                )
                findNavController().navigate(action)
            }
        }
        fragmentInterviewBinding.bottomBar.btnAdvance.setOnClickListener {
            val action =
                InterviewFragmentDirections.actionInterviewFragmentToAdvanceOptionsBottomSheet()
            findNavController().navigate(action)
        }
    }

    private fun isInputValid(): Boolean {
        return fragmentInterviewBinding.etJobRole.text.isNullOrBlank().not()
    }

    private fun getExperience(): String {
        return when (fragmentInterviewBinding.cgExperience.checkedChipId) {
            R.id.chip_internship -> "Internship"
            R.id.chip_entry_level -> "Entry Level"
            R.id.chip_intermediate -> "Intermediate"
            R.id.chip_professional -> "Professional"
            else -> "Any"
        }
    }

    private fun getFocusPoint(): String {
        return when (fragmentInterviewBinding.cgFocusPoint.checkedChipId) {
            R.id.chip_background_experience -> "Background Experience"
            R.id.chip_career_goals -> "Career Goals"
            R.id.chip_company_knowledge -> "Company Knowledge"
            R.id.chip_technical_skills -> "Technical Skills"
            R.id.chip_interpersonal_skills -> "Interpersonal Skills"
            R.id.chip_adaptability_flexibility -> "Adaptability/Flexibility"
            R.id.chip_problem_solving -> "Problem Solving"
            R.id.chip_leadership_management -> "Leadership/Management"
            R.id.chip_time_management -> "Time Management"
            R.id.chip_teamwork_collaboration -> "Teamwork/Collaboration"
            else -> "Any"
        }
    }

    private fun getTopics(): String {
        val topics = fragmentInterviewBinding.etTopic.text
        return when (topics.isNullOrBlank()) {
            true -> "Any"
            else -> topics.toString()
        }
    }
}