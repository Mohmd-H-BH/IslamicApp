package com.mhmdbh.quran.feature.qurani.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mhmdbh.quran.core.designsystem.icon.Icon
import com.mhmdbh.quran.core.designsystem.icon.QuranIcons
import com.mhmdbh.quran.core.designsystem.theme.Pink20
import com.mhmdbh.quran.core.designsystem.theme.Pink60
import com.mhmdbh.quran.core.designsystem.theme.QuranTheme
import com.mhmdbh.quran.core.designsystem.theme.White40
import com.mhmdbh.quran.feature.qurani.domain.quran.surah.SurahModel

@Preview
@Composable
private fun LastReadCardPreview() {
    QuranTheme {
        LastReadCard(
            surah = SurahModel.dummy.first().engName,
            ayah = "1",
        ){}
    }
}

@Composable
fun LastReadCard(
    modifier: Modifier = Modifier,
    surah: String,
    ayah: String,
    onClick: () -> Unit
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 12.dp, bottom = 12.dp)
            .clickable {
                onClick()
            }
            /*.shadow(8.dp)*/,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors().copy(
            //containerColor = Color
            //containerColor = MaterialTheme.colorScheme.primary
        ),
        elevation = CardDefaults.cardElevation(12.dp)
    ){
        
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
        ){

            Column(
                modifier = Modifier.padding(20.dp)
            ){

            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(painter = painterResource(id = Icon.DrawableResourceIcon(QuranIcons.Quran).id),
                    contentDescription = null,
                    tint = White40
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Last Read",
                    color = White40
                )
            }

            Spacer(modifier = Modifier.size(24.dp))

            Text(
                text= surah,
                color = White40
            )
            Text(
                text= "Ayah No: $ayah",
                color = White40
            )

        }

            Image(
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.BottomEnd)
                    .offset(x = 26.dp, y = 26.dp),
                painter = painterResource(id = Icon.DrawableResourceIcon(QuranIcons.Quran).id),
                contentDescription = null,
                colorFilter = ColorFilter.tint(White40)
            )
        }

    }
}