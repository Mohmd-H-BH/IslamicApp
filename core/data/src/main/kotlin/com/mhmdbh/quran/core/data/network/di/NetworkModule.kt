package com.mhmdbh.quran.core.data.network.di

import com.mhmdbh.quran.core.data.retrofit.QuranApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideBaseRetrofit(httpClient: OkHttpClient): Retrofit{

        return Retrofit
            .Builder()
            .client(httpClient)
            .addConverterFactory(provideGsonConverterFactory())
            .baseUrl("https://api.quran.com/api/v4/")
            .build()
    }

    @Provides
    fun provideQuranService(retrofit: Retrofit): QuranApi =
        retrofit.create(QuranApi::class.java)

}