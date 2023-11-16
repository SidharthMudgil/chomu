package com.sidharth.chomu.domain.usecase

import com.sidharth.chomu.domain.model.Prompt
import com.sidharth.chomu.domain.model.PromptResult
import com.sidharth.chomu.domain.repository.PromptRepository

class GetPromptResultUseCaseImpl(
    private val promptRepository: PromptRepository
) : GetPromptResultUseCase {

    override suspend fun invoke(prompt: Prompt): PromptResult {
        return promptRepository.generateResult(prompt.asd)
    }
}