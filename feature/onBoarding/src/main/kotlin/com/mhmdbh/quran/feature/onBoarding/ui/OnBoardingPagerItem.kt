package com.mhmdbh.quran.feature.onBoarding.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mhmdbh.quran.core.designsystem.icon.Icon
import com.mhmdbh.quran.core.designsystem.theme.QuranTheme
import com.mhmdbh.quran.core.designsystem.theme.White80
import com.mhmdbh.quran.core.ui.DevicePreviews
import com.mhmdbh.quran.feature.onBoarding.domian.BoardModel

@DevicePreviews
@Composable
private fun OnBoardingPagerItemPreview() {
    QuranTheme {
        OnBoardingPagerItem(
            icon = BoardModel.default.first().icon
        )
    }
}

@Composable
fun OnBoardingPagerItem(
    modifier: Modifier = Modifier,
    icon: Icon
) {

    Column(
        modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
    ) {

        /* when (icon) {
             is Icon.DrawableResourceIcon -> {

                 Icon(
                     modifier = Modifier
                         .fillMaxWidth()
                         .padding(16.dp)
                        ,
                     painter = painterResource(id = icon.id),
                     contentDescription = null
                 )

             }

             is Icon.ImageVectorIcon -> {
                 Icon(
                     modifier = Modifier
                         .fillMaxWidth()
                         .padding(16.dp)
                         ,
                     imageVector = icon.imageVector,
                     contentDescription = null
                 )

             }
         }*/

        Box(modifier = Modifier.fillMaxSize().padding(bottom = 24.dp)) {

            when (icon) {
                is Icon.DrawableResourceIcon -> {
                    Image(
                        modifier = Modifier
                            .size(260.dp)
                            .padding(16.dp)
                            .align(Alignment.BottomCenter),
                        painter = painterResource(id = icon.id),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(White80)
                    )


                }

                is Icon.ImageVectorIcon -> {
                    Icon(
                        modifier = Modifier
                            .size(260.dp)
                            .padding(16.dp)
                            .align(Alignment.BottomCenter),
                        imageVector = icon.imageVector,
                        contentDescription = null
                    )

                }
            }
        }
    }
}