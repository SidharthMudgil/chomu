package com.sidharth.chomu.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sidharth.chomu.R
import com.sidharth.chomu.core.constant.Constants
import com.sidharth.chomu.databinding.FragmentSocialBinding
import com.sidharth.chomu.domain.model.Options
import com.sidharth.chomu.presentation.component.AdvanceOptionsBottomSheet

class SocialFragment : Fragment() {

    private lateinit var fragmentSocialBinding: FragmentSocialBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentSocialBinding = FragmentSocialBinding.inflate(inflater)
        setupViewsAndListeners()
        return fragmentSocialBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findNavController().currentBackStackEntry
            ?.savedStateHandle
            ?.getLiveData<Options>(AdvanceOptionsBottomSheet.KEY_OPTIONS)
            ?.observe(viewLifecycleOwner) { options = it }
    }

    private fun setupViewsAndListeners() {
        fragmentSocialBinding.topBar.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        fragmentSocialBinding.topBar.tvTitle.text = getString(R.string.social)
        fragmentSocialBinding.bottomBar.btnGenerate.setOnClickListener {
            if (isInputValid()) {
                val action = SocialFragmentDirections.actionSocialFragmentToResultFragment(
                    prompt = getPrompt(),
                    command = Constants.COMMAND_SOCIAL
                )
                findNavController().navigate(action)
            }
        }
        fragmentSocialBinding.bottomBar.btnAdvance.setOnClickListener {
            val action = SocialFragmentDirections.actionSocialFragmentToAdvanceOptionsBottomSheet()
            findNavController().navigate(action)
        }
    }

    private fun getPlatform(): String {
        return when (fragmentSocialBinding.cgPlatform.checkedChipId) {
            R.id.chip_linkedin -> "LinkedIn"
            R.id.chip_twitter -> "Twitter"
            R.id.chip_facebook -> "Facebook"
            R.id.chip_instagram -> "Instagram"
            R.id.chip_threads -> "Threads"
            else -> "Other"
        }
    }

    private fun getContentType(): String {
        return when (fragmentSocialBinding.cgContentType.checkedChipId) {
            R.id.chip_message -> "Cold Message"
            R.id.chip_text -> "Text Post"
            R.id.chip_caption -> "Image Caption"
            R.id.chip_link -> "Link Description"
            else -> "Other"
        }
    }

    private fun getPrompt(): String {
        return "platform: ${getPlatform()}" +
                "contentType: ${getContentType()}" +
                "purpose: ${fragmentSocialBinding.etPurpose.text}" +
                "Formality: ${options.formality}" +
                "Tone: ${options.tone}" +
                "Length: ${options.length}" +
                "Style: ${options.style}"
    }

    private fun isInputValid(): Boolean {
        return fragmentSocialBinding.etPurpose.text.isNullOrBlank().not()
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