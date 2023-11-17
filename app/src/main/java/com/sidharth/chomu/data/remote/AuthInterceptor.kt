package com.sidharth.chomu.data.remote

import com.sidharth.chomu.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val modifiedRequest = originalRequest.newBuilder()
            .header("Authorization", "Bearer ${BuildConfig.API_KEY}")
            .build()

        return chain.proceed(modifiedRequest)
    }
}