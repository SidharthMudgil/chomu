package com.sidharth.chomu.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sidharth.chomu.domain.model.Assistant
import com.sidharth.chomu.domain.model.PromptResult
import com.sidharth.chomu.domain.usecase.GetPromptResultUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    private val getPromptResultUseCase: GetPromptResultUseCase
) : ViewModel() {

    private val _result = MutableSharedFlow<PromptResult>()
    val result: SharedFlow<PromptResult> = _result

    suspend fun fetchResult(
        prompt: String,
        assistant: Assistant
    ) = viewModelScope.launch {
        getPromptResultUseCase.invoke(
            message = prompt,
            assistant = assistant
        ).apply {
            _result.emit(this)
        }
    }
}
