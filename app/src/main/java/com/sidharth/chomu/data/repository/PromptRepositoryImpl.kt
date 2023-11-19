package com.sidharth.chomu.data.repository

import android.util.Log
import com.google.gson.Gson
import com.sidharth.chomu.data.remote.ChomuResponse
import com.sidharth.chomu.data.remote.ChomuService
import com.sidharth.chomu.domain.model.Prompt
import com.sidharth.chomu.domain.model.PromptResult
import com.sidharth.chomu.domain.repository.PromptRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PromptRepositoryImpl @Inject constructor(
    private val chomuService: ChomuService
) : PromptRepository {

    override suspend fun generateResult(prompt: Prompt) = flow {
        emit(PromptResult.Loading)
        val promptResult = chomuService.getPromptResult(prompt)
        Log.d("response  error", promptResult.errorBody()?.string().toString())
        val response = promptResult.body()?.toString()
        Log.d("response", response.toString())

        if (promptResult.isSuccessful) {
            if (response.isNullOrBlank().not()) {
                val res = Gson().fromJson(response, ChomuResponse::class.java)
                emit(PromptResult.Success(res.choices[0].message.content))
            } else {
                emit(PromptResult.Error)
            }
        } else {
            emit(PromptResult.Error)
        }
    }
}