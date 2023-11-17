package com.sidharth.chomu.di

import com.sidharth.chomu.core.constant.Constants
import com.sidharth.chomu.data.remote.ChomuService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
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