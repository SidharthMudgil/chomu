package com.sidharth.chomu.di

import com.sidharth.chomu.core.constant.Constants
import com.sidharth.chomu.data.remote.AuthInterceptor
import com.sidharth.chomu.data.remote.ChomuService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
//        val client = OkHttpClient.Builder()
//            .addInterceptor(AuthInterceptor())
//            .build()

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
//            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideChomuService(
        retrofit: Retrofit
    ): ChomuService {
        return retrofit.create(ChomuService::class.java)
    }

}