package com.example.workoutkotlinapp.src.components.Titles.ScreenTitle

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable()
fun ScreenTitle(text: String) {
    Text(
        modifier = Modifier.padding(bottom = 24.dp),
        text = text,
        fontWeight = FontWeight.Bold,
    )
}
