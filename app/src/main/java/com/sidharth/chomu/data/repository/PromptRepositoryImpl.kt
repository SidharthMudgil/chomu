package com.sidharth.chomu.data.repository

import com.sidharth.chomu.domain.model.PromptResult
import com.sidharth.chomu.domain.repository.PromptRepository

class PromptRepositoryImpl(

) : PromptRepository {

    override suspend fun generateResult(prompt: String): PromptResult {
        TODO()
    }
}