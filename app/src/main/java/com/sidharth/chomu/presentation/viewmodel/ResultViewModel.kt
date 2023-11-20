package com.sidharth.chomu.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sidharth.chomu.domain.model.PromptResult
import com.sidharth.chomu.domain.usecase.GetPromptResultUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    private val getPromptResultUseCase: GetPromptResultUseCase
) : ViewModel() {

    private val _result = MutableStateFlow<PromptResult>(PromptResult.Loading)
    val result: StateFlow<PromptResult> = _result

    suspend fun fetchResult(
        prompt: String,
        command: String,
    ) = viewModelScope.launch {
        getPromptResultUseCase.invoke(
            message = prompt,
            command = command
        ).collectLatest {
            _result.emit(it)
        }
    }
}
