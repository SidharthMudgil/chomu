package com.sidharth.chomu.data.repository

import com.sidharth.chomu.data.remote.ChomuService
import com.sidharth.chomu.domain.model.PromptResult
import com.sidharth.chomu.domain.repository.PromptRepository
import javax.inject.Inject

class PromptRepositoryImpl @Inject constructor(
    private val chomuService: ChomuService
) : PromptRepository {

    override suspend fun generateResult(prompt: String): PromptResult {
        TODO()
    }
}