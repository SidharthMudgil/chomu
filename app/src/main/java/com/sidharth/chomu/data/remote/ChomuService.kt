package com.sidharth.chomu.data.remote

import com.sidharth.chomu.BuildConfig
import com.sidharth.chomu.domain.model.Prompt
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

    interface ChomuService {

        @POST("completions")
        @Headers("Authorization: Bearer ${BuildConfig.API_KEY}")
        suspend fun getPromptResult(@Body prompt: Prompt): Response<ResponseBody>
    }