package com.mhmdbh.quran.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mhmdbh.quran.core.designsystem.R

val arFontNormal = Font(R.font.amiri_regular, FontWeight.Normal)
val arFontBold = Font(R.font.amiri_bold, FontWeight.Bold)

val arFontFamily = FontFamily(
    arFontNormal,
    arFontBold
)

fun getFontFamily(lang: String): FontFamily {

    return when (lang) {

        "ar" -> {
            FontFamily(
                Font(R.font.amiri_bold, FontWeight.Bold),
                Font(R.font.amiri_regular, FontWeight.Normal)
            )
        }

        "en" -> {
            FontFamily(
                Font(R.font.poppins_bold, FontWeight.Bold),
                Font(R.font.poppins_regular, FontWeight.Normal)
            )
        }

        else -> {
            FontFamily(
                Font(R.font.amiri_bold, FontWeight.Bold),
                Font(R.font.amiri_regular, FontWeight.Normal)
            )
        }
    }

}

// Set of Material typography styles to start with

val tempTypo = Typography()

fun getTypo(color: Color): Typography{
    return Typography(
        displayLarge = tempTypo.displayLarge.copy(
            fontFamily = getFontFamily("en"),
            fontWeight = FontWeight.Bold,
            color = color,
        ),
        displayMedium = tempTypo.displayMedium.copy(
            fontFamily = getFontFamily("en"),
            color = color,
        ),
        displaySmall = tempTypo.displaySmall.copy(
            fontFamily = getFontFamily("en"),
            color = color,
        ),
        headlineLarge = tempTypo.headlineLarge.copy(
            fontFamily = getFontFamily("en"),
            fontWeight = FontWeight.Bold,
            color = color,
        ),
        headlineMedium = tempTypo.headlineMedium.copy(
            fontFamily = getFontFamily("en"),
            color = color,
        ),
        headlineSmall = tempTypo.headlineSmall.copy(
            fontFamily = getFontFamily("en"),
            color = color,
        ),
        titleLarge = tempTypo.titleLarge.copy(
            fontFamily = getFontFamily("en"),
            fontWeight = FontWeight.Bold,
            color = color,
        ),
        titleMedium = tempTypo.titleMedium.copy(
            fontFamily = getFontFamily("en"),
            color = color,
        ),
        titleSmall = tempTypo.titleSmall.copy(
            fontFamily = getFontFamily("en"),
            color = color,
        ),
        bodyLarge = tempTypo.bodyLarge.copy(
            fontFamily = getFontFamily("en"),
            fontWeight = FontWeight.Bold,
            color = color,
        ),
        bodyMedium = tempTypo.bodyMedium.copy(
            fontFamily = getFontFamily("en"),
            color = color
        ),
        bodySmall = tempTypo.bodySmall.copy(fontFamily = getFontFamily("en")),
        labelLarge = tempTypo.labelLarge.copy(
            fontFamily = getFontFamily("en"),
            fontWeight = FontWeight.Bold,
            color = color,
        ),
        labelMedium = tempTypo.labelMedium.copy(
            fontFamily = getFontFamily("en"),
            color = PurpleGrey80
        ),
        labelSmall = tempTypo.labelSmall.copy(
            fontFamily = getFontFamily("en"),
            color = color,
        )
    )
}

val Typography = Typography(
    displayLarge = tempTypo.displayLarge.copy(
        fontFamily = getFontFamily("en"),
        fontWeight = FontWeight.Bold
    ),
    displayMedium = tempTypo.displayMedium.copy(fontFamily = getFontFamily("en")),
    displaySmall = tempTypo.displaySmall.copy(fontFamily = getFontFamily("en")),
    headlineLarge = tempTypo.headlineLarge.copy(
        fontFamily = getFontFamily("en"),
        fontWeight = FontWeight.Bold
    ),
    headlineMedium = tempTypo.headlineMedium.copy(fontFamily = getFontFamily("en")),
    headlineSmall = tempTypo.headlineSmall.copy(fontFamily = getFontFamily("en")),
    titleLarge = tempTypo.titleLarge.copy(
        fontFamily = getFontFamily("en"),
        fontWeight = FontWeight.Bold
    ),
    titleMedium = tempTypo.titleMedium.copy(fontFamily = getFontFamily("en")),
    titleSmall = tempTypo.titleSmall.copy(fontFamily = getFontFamily("en")),
    bodyLarge = tempTypo.bodyLarge.copy(
        fontFamily = getFontFamily("en"),
        fontWeight = FontWeight.Bold
    ),
    bodyMedium = tempTypo.bodyMedium.copy(fontFamily = getFontFamily("en")),
    bodySmall = tempTypo.bodySmall.copy(fontFamily = getFontFamily("en")),
    labelLarge = tempTypo.labelLarge.copy(
        fontFamily = getFontFamily("en"),
        fontWeight = FontWeight.Bold,
        //color =
    ),
    labelMedium = tempTypo.labelMedium.copy(fontFamily = getFontFamily("en"), color = PurpleGrey80),
    labelSmall = tempTypo.labelSmall.copy(fontFamily = getFontFamily("en")),
    /*bodyLarge = TextStyle(
        fontFamily = getFontFamily("en"),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )*/
)