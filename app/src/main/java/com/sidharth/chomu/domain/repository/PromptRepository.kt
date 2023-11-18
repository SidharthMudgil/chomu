package com.sidharth.chomu.domain.repository

import com.sidharth.chomu.domain.model.Prompt
import com.sidharth.chomu.domain.model.PromptResult

interface PromptRepository {
    suspend fun generateResult(prompt: Prompt): PromptResult
}