package com.example.workoutkotlinapp.src.screens.createWorkout.components.exercises.ExerciseItem

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.workoutkotlinapp.src.network.apiService.api.workout.ICreateExercise
import com.example.workoutkotlinapp.R

@Composable
fun ExerciseItem(exercise: ICreateExercise) {
    Column {
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = exercise.name)
        exercise.sets.forEachIndexed { index, set ->
            Text(text = stringResource(R.string.create_workout_exercise_item_text, index+ 1, set.weight, set.reps))
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}
