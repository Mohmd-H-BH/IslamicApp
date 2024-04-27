package com.mhmdbh.quran.feature.onBoarding.ui

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mhmdbh.quran.core.designsystem.theme.OrangeLight80
import com.mhmdbh.quran.core.designsystem.theme.QuranTheme
import com.mhmdbh.quran.core.ui.DevicePreviews
import com.mhmdbh.quran.feature.onBoarding.R
import com.mhmdbh.quran.feature.onBoarding.domian.BoardModel
import kotlinx.coroutines.launch

@DevicePreviews
@Composable
private fun OnBoardingScreenPreview() {
    QuranTheme {
        OnBoardingScreen(
            data = BoardModel.default
        ) {}
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    data: List<BoardModel>,
    onBoardingState: OnBoardingState = rememberOnBoardingState(
        pagerState = rememberPagerState(pageCount = { data.size }),
        onBoardModel = data
    ),
    proceedNextScreen: () -> Unit
) {

    val title = onBoardingState.title.value
    val isLastPage = onBoardingState.isLastPage.value
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        //Title
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Quran App",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.size(32.dp))



        //Pages
        Box(
            modifier = Modifier
                .fillMaxHeight(0.7f)
                .padding(start = 12.dp, end = 12.dp)
                .clip(RoundedCornerShape(16.dp))
        ) {

            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.img_bg_frame_hq),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )

            OnBoardingPagesSlider(
                modifier = Modifier.fillMaxSize(),
                pagerState = onBoardingState.pagerState,
                data = BoardModel.default,
            )
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 65.dp, end = 65.dp)
                .offset(y = (-28).dp)
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                containerColor = OrangeLight80
            ),
            onClick = {
                if (isLastPage) {
                    Log.d("TAG", "OnBoardingScreen: Last Page")
                    proceedNextScreen()
                } else {
                    Log.d("TAG", "OnBoardingScreen: Next Page")

                    coroutineScope.launch {
                        onBoardingState.pagerState.animateScrollToPage(
                            page = onBoardingState.pagerState.currentPage+1
                        )
                    }
                }

            }) {
            Text(
                modifier = Modifier.padding(
                    top = 8.dp, bottom = 8.dp,
                    start = 12.dp, end = 12.dp
                ),
                text = if (isLastPage)
                    stringResource(id = R.string.title_get_started)
                else
                    stringResource(id = R.string.title_next),
                style = MaterialTheme.typography.bodyLarge
            )
        }

        //Spacer(modifier = Modifier.size(12.dp))

        AnimatedVisibility(
            visible = true
        ) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = title,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}