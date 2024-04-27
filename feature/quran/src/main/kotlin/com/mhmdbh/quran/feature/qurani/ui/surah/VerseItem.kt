package com.mhmdbh.quran.feature.qurani.ui.surah

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mhmdbh.quran.core.data.model.Verse
import com.mhmdbh.quran.core.designsystem.theme.QuranTheme
import com.mhmdbh.quran.core.designsystem.theme.White40
import com.mhmdbh.quran.core.designsystem.theme.arFontFamily
import com.mhmdbh.quran.core.ui.DevicePreviews

@DevicePreviews
@Composable
private fun VerseItemPreview() {
    QuranTheme {
        VerseItem(verse = Verse.dummy)
    }
}

@Stable
@Composable
fun VerseItem(
    modifier: Modifier = Modifier,
    verse: Verse
) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        
        Box(
            modifier = Modifier.fillMaxWidth()
                .shadow(14.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.surface)

        ){

            Card(
                modifier = Modifier.align(Alignment.CenterStart)
                    .padding(8.dp)
                    .widthIn(36.dp),
                    //.width(34.dp),
                shape = CircleShape,
                colors = CardDefaults.cardColors().copy(
                    MaterialTheme.colorScheme.primary
                )
            ){
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(6.dp),
                    text = "${verse.verseNumber}", //"290",
                    color = White40,
                    textAlign = TextAlign.Center
                )
            }
            
            Row(
                modifier = Modifier.align(Alignment.CenterEnd)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    modifier = Modifier,
                    imageVector = Icons.Outlined.Share,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
                Icon(
                    modifier = Modifier.size(32.dp),
                    imageVector = Icons.Outlined.PlayArrow,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
                Icon(
                    modifier = Modifier,
                    imageVector = Icons.Outlined.BookmarkBorder,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
        
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = verse.primary,
            fontFamily = arFontFamily,
            style = MaterialTheme.typography.titleLarge.copy(
                textDirection = TextDirection.ContentOrRtl,
                lineHeight = 44.sp,
            ),
            //color = MaterialTheme.colorScheme.primary,
        )

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = verse.secondary,
            style = MaterialTheme.typography.bodyLarge,
            //color = MaterialTheme.colorScheme.primary
        )
    }

}