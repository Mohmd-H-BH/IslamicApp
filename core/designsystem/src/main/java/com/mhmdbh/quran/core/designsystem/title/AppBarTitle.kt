package com.mhmdbh.quran.core.designsystem.title

import androidx.annotation.StringRes

sealed class AppBarTitle {

    data class StringTitle(val title: String): AppBarTitle()
    data class StringResourceTitle(@StringRes val id: Int): AppBarTitle()
}