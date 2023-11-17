package com.sidharth.chomu.di

import com.sidharth.chomu.data.remote.ChomuService
import com.sidharth.chomu.data.repository.PromptRepositoryImpl
import com.sidharth.chomu.domain.repository.PromptRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providePromptRepository(chomuService: ChomuService): PromptRepository {
        return PromptRepositoryImpl(chomuService)
    }
}