package com.sidharth.chomu.domain.usecase

import com.sidharth.chomu.core.constant.Constants
import com.sidharth.chomu.domain.model.Message
import com.sidharth.chomu.domain.model.Prompt
import com.sidharth.chomu.domain.model.PromptResult
import com.sidharth.chomu.domain.repository.PromptRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetChatResultUseCaseImpl @Inject constructor(
    private val promptRepository: PromptRepository
) : GetChatResultUseCase {

    override suspend fun invoke(messages: List<Message>): Flow<PromptResult> {
        val mutableMessages = messages.toMutableList()
        mutableMessages.add(
            0, Message(
                role = "system",
                content = Constants.COMMAND_CHOMU
            )
        )
        return promptRepository.generateResult(
            Prompt(
                model = Constants.MODEL,
                messages = mutableMessages
            )
        )
    }
}