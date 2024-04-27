package com.mhmdbh.quran.core.domain.usecase.quran.di

import com.mhmdbh.quran.core.domain.usecase.quran.GetQuranChapterUseCase
import com.mhmdbh.quran.core.domain.usecase.quran.GetQuranChapterUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun provideQuranChaptersUseCase(
        quranChapterUseCaseImpl: GetQuranChapterUseCaseImpl
    ): GetQuranChapterUseCase
}