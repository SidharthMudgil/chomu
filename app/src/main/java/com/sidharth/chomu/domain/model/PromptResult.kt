package com.sidharth.chomu.domain.model

sealed class PromptResult {
    data class Success(val data: String) : PromptResult()
    data object Loading : PromptResult()
    data object Error : PromptResult()
}
