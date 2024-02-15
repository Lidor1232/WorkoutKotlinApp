package com.example.workoutkotlinapp.src.screens.CreateWorkout.components.Title

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Title() {
    Text(
        text = "Create Workout",
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 24.dp),
    )
}
