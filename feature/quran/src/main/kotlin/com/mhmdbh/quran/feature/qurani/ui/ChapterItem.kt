package com.mhmdbh.quran.feature.qurani.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mhmdbh.quran.core.data.model.Chapter
import com.mhmdbh.quran.core.designsystem.theme.QuranTheme
import com.mhmdbh.quran.core.designsystem.theme.arFontFamily
import com.mhmdbh.quran.core.ui.DevicePreviews
import com.mhmdbh.quran.core.designsystem.R as designSystemR

@DevicePreviews
@Composable
private fun SurahItemPreview() {
    QuranTheme {
        ChapterItem(chapter = Chapter.dummy){}
    }
}

@Stable
@Composable
fun ChapterItem(
    modifier: Modifier = Modifier,
    chapter: Chapter,
    onClick: () -> Unit
) {

    Row(
        modifier = modifier
            .clickable { onClick() }
            //.padding(top = 16.dp, bottom = 16.dp)
        ,
        verticalAlignment = Alignment.CenterVertically
    ) {

        //Surah Num
        Box(
            //modifier = Modifier.wrapContentSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.size(42.dp),
                painter = painterResource(id = designSystemR.drawable.ic_ayah_border),
                contentDescription = null,
                //contentScale = ContentScale.FillBounds
            )

            Text(
                modifier = Modifier,
                text = "${chapter.id}",
                //color = MaterialTheme.colorScheme.onPrimary
            )
        }

        Spacer(modifier = Modifier.size(12.dp))

        Column(
            modifier = Modifier.fillMaxWidth(0.70f)
        ) {
            Text(text = chapter.nameComplex)
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = chapter.revelationPlace,
                    style = MaterialTheme.typography.labelMedium
                )
                Icon(
                    modifier = Modifier
                        .padding(6.dp)
                        .size(8.dp),
                    imageVector = Icons.Filled.Circle,
                    contentDescription = null
                )
                Text(
                    text = "${chapter.versesCount} Verses",
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }

        Spacer(modifier = Modifier.size(12.dp))

        Text(
            modifier = Modifier.fillMaxWidth(1f),
            text = chapter.nameArabic,
            textAlign = TextAlign.End,
            fontFamily = arFontFamily,
            color = MaterialTheme.colorScheme.primary
        )
    }
}