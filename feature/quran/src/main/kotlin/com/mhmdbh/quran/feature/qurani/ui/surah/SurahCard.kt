package com.mhmdbh.quran.feature.qurani.ui.surah

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mhmdbh.quran.core.data.model.Chapter
import com.mhmdbh.quran.core.designsystem.icon.Icon
import com.mhmdbh.quran.core.designsystem.icon.QuranIcons
import com.mhmdbh.quran.core.designsystem.theme.Pink20
import com.mhmdbh.quran.core.designsystem.theme.Pink60
import com.mhmdbh.quran.core.designsystem.theme.White40
import com.mhmdbh.quran.core.designsystem.theme.arFontFamily
import com.mhmdbh.quran.core.ui.DevicePreviews

@Composable
fun SurahCard(
    modifier: Modifier = Modifier,
    //surahModel: SurahModel,
    chapter: Chapter
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 12.dp, bottom = 12.dp)
            .shadow(22.dp),
        shape = RoundedCornerShape(16.dp),
        //elevation = CardDefaults.cardElevation(22.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Pink20,
                            Pink60,
                        )
                    )
                ),
        ) {

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .matchParentSize()
                    .align(Alignment.BottomEnd)
                    .alpha(.1f)
                    .offset(
                        x = 110.dp,
                        y = 40.dp,
                    ),
                painter = painterResource(id = Icon.DrawableResourceIcon(QuranIcons.Quran).id),
                contentDescription = null,
                colorFilter = ColorFilter.tint(White40),
                //contentScale = ContentScale.Inside
            )

            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .align(Alignment.Center),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = chapter.nameComplex,//surahModel.engName,
                    color = White40,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.size(12.dp))

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .padding(start = 32.dp, end = 32.dp)
                        .background(MaterialTheme.colorScheme.tertiary)

                )

                Spacer(modifier = Modifier.size(12.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = chapter.translatedName,
                    color = White40,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.size(24.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = chapter.revelationPlace,//surahModel.type,
                        style = MaterialTheme.typography.titleMedium,
                        color = White40,
                    )
                    Icon(
                        modifier = Modifier
                            .padding(6.dp)
                            .size(8.dp),
                        imageVector = Icons.Filled.Circle,
                        contentDescription = null,
                        tint = White40,
                    )
                    Text(
                        text = "${chapter.versesCount} Verses",
                        style = MaterialTheme.typography.titleMedium,
                        color = White40,
                    )
                }


                Spacer(modifier = Modifier.size(24.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "بِسْـــــــــمِ اللهِ الرَّحْمنِ الرَّحِيمِ",
                    color = White40,
                    fontFamily = arFontFamily,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )

            }
        }
    }
}

@DevicePreviews
@Composable
private fun SurahCardPreview(
) {
    SurahCard(
        modifier = Modifier,
        //surahModel = SurahModel.dummy.first(),
        chapter = Chapter.dummy
    )
}