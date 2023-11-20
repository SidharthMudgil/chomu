package com.sidharth.chomu.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sidharth.chomu.R
import com.sidharth.chomu.core.constant.Constants
import com.sidharth.chomu.databinding.FragmentEmailBinding
import com.sidharth.chomu.domain.model.Options
import com.sidharth.chomu.presentation.component.AdvanceOptionsBottomSheet

class EmailFragment : Fragment() {

    private lateinit var fragmentEmailBinding: FragmentEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentEmailBinding = FragmentEmailBinding.inflate(inflater)
        setupViewsAndListeners()
        return fragmentEmailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findNavController().currentBackStackEntry
            ?.savedStateHandle
            ?.getLiveData<Options>(AdvanceOptionsBottomSheet.KEY_OPTIONS)
            ?.observe(viewLifecycleOwner) { options = it }
    }

    private fun setupViewsAndListeners() {
        fragmentEmailBinding.topBar.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        fragmentEmailBinding.topBar.tvTitle.text = getString(R.string.email)
        fragmentEmailBinding.bottomBar.btnGenerate.setOnClickListener {
            if (isInputValid()) {
                val action = EmailFragmentDirections.actionEmailFragmentToResultFragment(
                    prompt = getPrompt(),
                    command = Constants.COMMAND_EMAIL
                )
                findNavController().navigate(action)
            }
        }
        fragmentEmailBinding.bottomBar.btnAdvance.setOnClickListener {
            val action = EmailFragmentDirections.actionEmailFragmentToAdvanceOptionsBottomSheet()
            findNavController().navigate(action)
        }
    }

    private fun getPrompt(): String {
        return "recipient info: ${fragmentEmailBinding.etRecipientInfo.text}" +
                "purpose: ${fragmentEmailBinding.etPurpose.text}" +
                "Formality: ${options.formality}" +
                "Tone: ${options.tone}" +
                "Length: ${options.length}" +
                "Style: ${options.style}"
    }

    private fun isInputValid(): Boolean {
        return (fragmentEmailBinding.etPurpose.text.isNullOrBlank() && fragmentEmailBinding.etRecipientInfo.text.isNullOrBlank()).not()
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
