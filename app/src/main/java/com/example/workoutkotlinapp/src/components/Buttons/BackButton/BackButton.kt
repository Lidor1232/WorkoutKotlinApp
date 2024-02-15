package com.example.workoutkotlinapp.src.components.Buttons.BackButton

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun BackButton(onClick: () -> Unit) {
    Button(onClick = {
        onClick()
    }) {
        Text(text = "Back")
    }
}
