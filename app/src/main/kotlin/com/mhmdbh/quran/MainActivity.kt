package com.mhmdbh.quran

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mhmdbh.quran.core.designsystem.theme.QuranTheme
import com.mhmdbh.quran.feature.onBoarding.domian.BoardModel
import com.mhmdbh.quran.feature.onBoarding.ui.OnBoardingScreen
import com.mhmdbh.quran.ui.QuranApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuranTheme {

                val haveToShowOnBoarding = rememberSaveable {
                    mutableStateOf(QuranApplication.isFirstRun)
                }

                if (haveToShowOnBoarding.value)
                    OnBoardingScreen(data = BoardModel.default){
                        haveToShowOnBoarding.value = false
                    }
                else
                    QuranApp(
                        windowSizeClass = calculateWindowSizeClass(activity = this)
                    )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuranTheme {}
}