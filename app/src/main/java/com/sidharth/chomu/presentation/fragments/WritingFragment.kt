package com.sidharth.chomu.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sidharth.chomu.R
import com.sidharth.chomu.core.constant.Constants
import com.sidharth.chomu.databinding.FragmentWritingBinding
import com.sidharth.chomu.domain.model.Options
import com.sidharth.chomu.presentation.component.AdvanceOptionsBottomSheet

class WritingFragment : Fragment() {

    private lateinit var fragmentWritingBinding: FragmentWritingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentWritingBinding = FragmentWritingBinding.inflate(inflater)
        setupViewsAndListeners()
        return fragmentWritingBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findNavController().currentBackStackEntry
            ?.savedStateHandle
            ?.getLiveData<Options>(AdvanceOptionsBottomSheet.KEY_OPTIONS)
            ?.observe(viewLifecycleOwner) { options = it }
    }

    private fun setupViewsAndListeners() {
        fragmentWritingBinding.topBar.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        fragmentWritingBinding.topBar.tvTitle.text = getString(R.string.writing)

        fragmentWritingBinding.bottomBar.btnGenerate.setOnClickListener {
            if (isInputValid()) {
                val action = WritingFragmentDirections.actionWritingFragmentToResultFragment(
                    prompt = getPrompt(),
                    command = Constants.COMMAND_WRITING
                )
                findNavController().navigate(action)
            }
        }
        fragmentWritingBinding.bottomBar.btnAdvance.setOnClickListener {
            val action =
                WritingFragmentDirections.actionWritingFragmentToAdvanceOptionsBottomSheet()
            findNavController().navigate(action)
        }
    }

    private fun getContentType(): String {
        return when (fragmentWritingBinding.cgContentType.checkedChipId) {
            R.id.chip_essay -> "Essay"
            R.id.chip_poetry -> "Poetry"
            R.id.chip_short_story -> "Short Story"
            R.id.chip_novel -> "Novel"
            R.id.chip_article -> "Article"
            R.id.chip_technical_writing -> "Technical Writing"
            R.id.chip_script_screenplay -> "Script/Screenplay"
            R.id.chip_journalism -> "Journalism"
            R.id.chip_letter -> "Letter"
            R.id.chip_blog_post -> "Blog Post"
            R.id.chip_review -> "Review"
            R.id.chip_speech -> "Speech"
            else -> "Other"
        }
    }

    private fun getPrompt(): String {
        return "content type: ${getContentType()}" +
                "topic: ${fragmentWritingBinding.etTopic.text}" +
                "Formality: ${options.formality}" +
                "Tone: ${options.tone}" +
                "Length: ${options.length}" +
                "Style: ${options.style}"
    }

    private fun isInputValid(): Boolean {
        return fragmentWritingBinding.etTopic.text.isNullOrBlank().not()
    }

    companion object {
        private var options = Options(
            formality = "Neutral",
            tone = "Cooperative",
            length = "Medium",
            style = "None"
        )
    }
}