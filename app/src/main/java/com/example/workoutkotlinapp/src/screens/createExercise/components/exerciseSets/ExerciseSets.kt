package com.example.workoutkotlinapp.src.screens.createExercise.components.exerciseSets

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.workoutkotlinapp.src.screens.createExercise.components.exerciseSets.ExerciseSetsList.ExerciseSetsList

@Composable
fun ExerciseSets() {
    Spacer(modifier = Modifier.height(24.dp))
    Text(text = "Sets")
    ExerciseSetsList()
    Spacer(modifier = Modifier.height(24.dp))
}
