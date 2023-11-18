package com.sidharth.chomu.domain.usecase

import com.sidharth.chomu.domain.model.Assistant
import com.sidharth.chomu.domain.model.PromptResult

interface GetPromptResultUseCase {
    suspend fun invoke(
        message: String,
        assistant: Assistant
    ): PromptResult
}