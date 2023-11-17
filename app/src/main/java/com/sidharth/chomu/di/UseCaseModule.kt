package com.sidharth.chomu.di

import com.sidharth.chomu.domain.repository.PromptRepository
import com.sidharth.chomu.domain.usecase.GetPromptResultUseCase
import com.sidharth.chomu.domain.usecase.GetPromptResultUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    @Singleton
    fun provideGetPromptResultUseCase(
        promptRepository: PromptRepository
    ): GetPromptResultUseCase {
        return GetPromptResultUseCaseImpl(promptRepository)
    }
}