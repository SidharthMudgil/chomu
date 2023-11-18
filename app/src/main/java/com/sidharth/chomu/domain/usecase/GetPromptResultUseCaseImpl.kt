package com.sidharth.chomu.domain.usecase

import com.sidharth.chomu.domain.model.Assistant
import com.sidharth.chomu.domain.model.Message
import com.sidharth.chomu.domain.model.Prompt
import com.sidharth.chomu.domain.model.PromptResult
import com.sidharth.chomu.domain.repository.PromptRepository
import javax.inject.Inject

class GetPromptResultUseCaseImpl @Inject constructor(
    private val promptRepository: PromptRepository
) : GetPromptResultUseCase {

    override suspend fun invoke(
        message: String,
        assistant: Assistant
    ): PromptResult {
        return promptRepository.generateResult(
            Prompt(
                model = "gpt-3.5-turbo",
                messages = listOf(
                    Message(
                        role = "system",
                        content = assistant.command
                    ),
                    Message(
                        role = "user",
                        content = message
                    ),
                )
            )
        )
    }
}