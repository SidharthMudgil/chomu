package com.sidharth.chomu.domain.usecase

import com.sidharth.chomu.domain.model.Message
import com.sidharth.chomu.domain.model.PromptResult
import kotlinx.coroutines.flow.Flow

interface GetChatResultUseCase {

    suspend fun invoke(
        messages: List<Message>
    ): Flow<PromptResult>
}