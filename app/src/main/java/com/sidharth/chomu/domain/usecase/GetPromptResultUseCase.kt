package com.sidharth.chomu.domain.usecase

import com.sidharth.chomu.domain.model.Prompt
import com.sidharth.chomu.domain.model.PromptResult

interface GetPromptResultUseCase {
    suspend fun invoke(prompt: Prompt): PromptResult
}