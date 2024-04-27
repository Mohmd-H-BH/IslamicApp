package com.mhmdbh.quran.core.domain.usecase.quran

import com.mhmdbh.quran.core.data.model.Chapter
import kotlinx.coroutines.flow.Flow

interface GetQuranChapterUseCase {
    fun getChapters(): Flow<List<Chapter>>
}