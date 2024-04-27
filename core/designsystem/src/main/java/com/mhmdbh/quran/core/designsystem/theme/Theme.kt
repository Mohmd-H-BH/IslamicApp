package com.mhmdbh.quran.core.designsystem.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    onPrimary = White80,
    secondary = PurpleGrey80,
    onSecondary = White80,
    tertiary = Pink80,
    //onTertiary = White80,
    //primaryContainer = White80,
    //onPrimaryContainer = White80,
    background = BlueDark80,
    onBackground = White80,
    surface = BlueLight80,
    //onSurface = White80,
    surfaceContainer = BlueDark80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    onPrimary = Color.Black,
    secondary = PurpleGrey40,
    onSecondary = Purple40,
    surface = White40,
    onSurface = Purple40,
    tertiary = Pink40,
    background = White40,
    onBackground = Color.Black,
    //surface = White80,
    //onSurface = Color.Black,

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun QuranTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        /*dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }*/

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = getTypo(colorScheme.onPrimary),
    ) {
            content()
    }


    /*  MaterialTheme(
          colorScheme = colorScheme,
          typography = Typography,
          content = content
      )*/
}