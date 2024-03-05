package com.example.workoutkotlinapp.src.components.ErrorMessage

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable()
fun ErrorMessage(modifier: Modifier = Modifier, error: String) {
    Text(
        modifier = modifier.padding(bottom = 16.dp),
        text = error,
        color = Color.Red,
    )
}
