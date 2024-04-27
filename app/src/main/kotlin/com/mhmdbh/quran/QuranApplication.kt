package com.mhmdbh.quran

import android.app.Application
import com.mhmdbh.quran.core.data.model.Chapter
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
open class QuranApplication: Application() {

    companion object{
        var isFirstRun = true
    }
}