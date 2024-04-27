package com.mhmdbh.quran.core.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Construction
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ComingSoon(modifier: Modifier = Modifier) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Icon(
            modifier = Modifier.size(100.dp),
            imageVector = Icons.Filled.Construction,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )

        Text(
            //modifier = ,
            text = "Coming Soon, Inshallah",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center
        )
        //Text(navController.currentBackStackEntry?.destination?.route ?: "Unknown")
    }
}