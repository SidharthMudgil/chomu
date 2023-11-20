package com.sidharth.chomu.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sidharth.chomu.domain.model.Message
import com.sidharth.chomu.domain.model.PromptResult
import com.sidharth.chomu.domain.usecase.GetChatResultUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val getChatResultUseCase: GetChatResultUseCase
) : ViewModel() {

    private val _messages = MutableStateFlow<List<Message>>(emptyList())
    val messages: StateFlow<List<Message>> = _messages

    suspend fun fetchMessages(
        message: Message
    ) = viewModelScope.launch {
        var msgs = messages.value.toMutableList()
        msgs.add(message)
        _messages.emit(msgs)

        getChatResultUseCase.invoke(
            messages.value
        ).collectLatest {
            when (it) {
                is PromptResult.Error -> {
                    messages.value.toMutableList().dropLast(1).apply {
                        _messages.emit(this)
                    }
                }

                is PromptResult.Loading -> {
                    msgs = messages.value.toMutableList()
                    msgs.add(
                        Message("assistant", "Typing...")
                    )
                    _messages.emit(msgs)
                }

                is PromptResult.Success -> {
                    msgs = messages.value.toMutableList()
                    msgs.removeLast()
                    msgs.add(
                        Message("assistant", it.data)
                    )
                    _messages.emit(msgs)
                }
            }
        }
    }
}
