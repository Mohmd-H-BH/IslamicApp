package com.mhmdbh.quran.feature.onBoarding.ui

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.mhmdbh.quran.feature.onBoarding.domian.BoardModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingPagesSlider(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    data: List<BoardModel>,
) {

    Column(modifier) {
        HorizontalPager(
            state = pagerState
        ) { page ->
            OnBoardingPagerItem(icon = data[page].icon)
        }
    }
}