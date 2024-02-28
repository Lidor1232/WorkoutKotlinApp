package com.example.workoutkotlinapp.src.screens.createWorkout.components.exercises.ExerciseItem

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.workoutkotlinapp.src.network.apiService.api.workout.ICreateExercise

@Composable
fun ExerciseItem(exercise: ICreateExercise) {
    Column {
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = exercise.name)
        exercise.sets.forEachIndexed { index, set ->
            Text(text = "Set number ${index + 1}: Weight ${set.weight}, Reps ${set.reps}")
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}
