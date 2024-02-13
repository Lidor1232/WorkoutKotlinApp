package com.example.workoutkotlinapp.src.screens.WorkoutDetails.components.Exercises.ExerciseItem

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.workoutkotlinapp.src.types.Exercise

@Composable
fun ExerciseItem(
    exercise: Exercise,
    index: Int,
) {
    Spacer(modifier = Modifier.height(24.dp))
    Text(text = "Exercise Number: ${index + 1}")
    Text(text = exercise.name)
    Spacer(modifier = Modifier.height(16.dp))
    Text(text = "Sets:")
    Spacer(modifier = Modifier.height(8.dp))
    Column {
        exercise.sets!!.forEachIndexed { index, set ->
            Text(text = "Reps: ${set.reps}, Weight: ${set.weight}")
        }
    }
    Spacer(modifier = Modifier.height(24.dp))
}