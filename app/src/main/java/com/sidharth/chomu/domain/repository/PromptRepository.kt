package com.sidharth.chomu.domain.repository

import com.sidharth.chomu.domain.model.Prompt
import com.sidharth.chomu.domain.model.PromptResult
import kotlinx.coroutines.flow.Flow

interface PromptRepository {
    suspend fun generateResult(prompt: Prompt): Flow<PromptResult>
}