package com.sidharth.chomu.domain.usecase

import com.sidharth.chomu.domain.model.PromptResult
import kotlinx.coroutines.flow.Flow

interface GetPromptResultUseCase {
    suspend fun invoke(
        message: String,
        command: String
    ): Flow<PromptResult>
}