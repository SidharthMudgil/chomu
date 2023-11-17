package com.sidharth.chomu.data.remote

import com.sidharth.chomu.BuildConfig
import retrofit2.http.Headers
import retrofit2.http.POST

interface ChomuService {

    @POST
    @Headers("{Authorization: ${BuildConfig.API_KEY}}")
    suspend fun getPromptResult()
}