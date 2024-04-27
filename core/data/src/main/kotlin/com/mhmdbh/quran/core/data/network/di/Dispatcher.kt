package com.mhmdbh.quran.core.data.network.di

import javax.inject.Qualifier


@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher( val quranDispatcher: QuranDispatchers)

enum class QuranDispatchers{
    Main,
    Default,
    IO
}