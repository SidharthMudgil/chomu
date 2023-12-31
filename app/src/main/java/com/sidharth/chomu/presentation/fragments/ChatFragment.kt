package com.sidharth.chomu.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sidharth.chomu.R
import com.sidharth.chomu.core.utils.KeyboardUtils
import com.sidharth.chomu.databinding.FragmentChatBinding
import com.sidharth.chomu.domain.model.Message
import com.sidharth.chomu.presentation.adapter.ChatAdapter
import com.sidharth.chomu.presentation.viewmodel.ChatViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ChatFragment : Fragment() {

    private val chatFragmentArgs: ChatFragmentArgs by navArgs()
    private val chatViewModel: ChatViewModel by viewModels()
    private lateinit var fragmentChatBinding: FragmentChatBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentChatBinding = FragmentChatBinding.inflate(inflater)
        fetchMessages(
            Message(
                role = "user",
                content = chatFragmentArgs.message
            )
        )
        setupRecyclerView()
        setupListeners()
        return fragmentChatBinding.root
    }

    private fun fetchMessages(message: Message) {
        lifecycleScope.launch {
            chatViewModel.fetchMessages(message)
        }
    }

    private fun setupListeners() {
        fragmentChatBinding.topBar.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        fragmentChatBinding.searchView.etInput.setOnEditorActionListener { _, _, _ ->
            onSendButtonClick()
            true
        }
        fragmentChatBinding.topBar.tvTitle.text = getString(R.string.chat)
        fragmentChatBinding.searchView.btnSend.setOnClickListener {
            onSendButtonClick()
        }
    }

    private fun onSendButtonClick() {
        if (fragmentChatBinding.searchView.etInput.text.isNullOrBlank().not()) {
            KeyboardUtils.hideKeyboard(requireContext(), fragmentChatBinding.searchView.etInput)
            fetchMessages(
                Message(
                    role = "user",
                    content = fragmentChatBinding.searchView.etInput.text.toString()
                )
            )
            fragmentChatBinding.searchView.etInput.setText("")
        }
    }

    private fun setupRecyclerView() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                chatViewModel.messages.collectLatest {
                    fragmentChatBinding.rvChat.adapter = ChatAdapter(it)
                }
            }
        }
    }
}