package com.example.workoutkotlinapp.src.screens.WorkoutDetails.components.Exercises

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.WorkoutDetails.WorkoutDetailsViewModel
import com.example.workoutkotlinapp.src.screens.WorkoutDetails.components.Exercises.ExerciseItem.ExerciseItem

@Composable
fun Exercises() {
    val workoutDetailsViewModel: WorkoutDetailsViewModel = viewModel()

    val exercises by workoutDetailsViewModel.state.map { it.getExercises.exercises }.observeAsState()

    Column {
        exercises!!.forEachIndexed { index, exercise ->
            ExerciseItem(exercise, index)
        }
    }
}
