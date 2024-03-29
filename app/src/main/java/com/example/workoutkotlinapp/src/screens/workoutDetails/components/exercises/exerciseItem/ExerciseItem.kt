package com.example.workoutkotlinapp.src.screens.workoutDetails.components.exercises.exerciseItem

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.workoutkotlinapp.src.types.Exercise

@Composable
fun ExerciseItem(
    exercise: Exercise,
    index: Int,
) {
    Spacer(modifier = Modifier.height(24.dp))
    Text(
        modifier = Modifier.padding(bottom = 16.dp),
        text = "Exercise Number: ${index + 1}",
        fontWeight = FontWeight.Bold,
    )
    Text(text = "Name: ${exercise.name}")
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        modifier = Modifier.padding(bottom = 16.dp),
        text = "Sets:",
        fontWeight = FontWeight(600),
    )
    Spacer(modifier = Modifier.height(8.dp))
    Column {
        exercise.sets.forEachIndexed { index, set ->
            Text(text = "Reps: ${set.reps}, Weight: ${set.weight}")
        }
    }
    Spacer(modifier = Modifier.height(24.dp))
}
