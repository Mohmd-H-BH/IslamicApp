package com.mhmdbh.quran.core.data.network.di

import com.mhmdbh.quran.core.data.repository.quran.QuranRepository
import com.mhmdbh.quran.core.data.repository.quran.QuranRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun provideQuranRepo(quranRepositoryImpl: QuranRepositoryImpl): QuranRepository
}