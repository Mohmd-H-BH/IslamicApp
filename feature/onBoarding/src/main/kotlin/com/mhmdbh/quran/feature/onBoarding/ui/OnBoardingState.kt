package com.mhmdbh.quran.feature.onBoarding.ui

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import com.mhmdbh.quran.feature.onBoarding.R
import com.mhmdbh.quran.feature.onBoarding.domian.BoardModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun rememberOnBoardingState(
    pagerState: PagerState,
    onBoardModel: List<BoardModel>
): OnBoardingState {

    return remember(pagerState, onBoardModel) {
        OnBoardingState(pagerState, onBoardModel)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Stable
class OnBoardingState(
    val pagerState: PagerState,
    private val data: List<BoardModel>
) {

    val title : MutableState<String>
        get() {
        return mutableStateOf(data[pagerState.currentPage].title)
    }

    val pagesComposables: List<Unit>
        @Composable get() = run {
            data.map {
                OnBoardingPagerItem(icon = it.icon)
            }
        }

    val isLastPage: Boolean get()=pagerState.currentPage == data.size - 1
        //Log.d("OnBoardingState", "pagerState.currentPage = ${pagerState.currentPage}")
        //return mutableStateOf(pagerState.currentPage == data.size - 1)

    val btnTitle: String
        @Composable get() = if (isLastPage) {
            stringResource(id = R.string.title_get_started)
        } else
            stringResource(id = R.string.title_next)
}