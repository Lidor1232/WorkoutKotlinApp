package com.example.workoutkotlinapp.src.screens.Login.components.Title

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Title() {
    Text(text = "Login Screen", modifier = Modifier.padding(bottom = 16.dp))
}
