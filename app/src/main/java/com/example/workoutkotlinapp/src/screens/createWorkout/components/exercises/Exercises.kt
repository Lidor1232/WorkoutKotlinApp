package com.example.workoutkotlinapp.src.screens.createWorkout.components.exercises

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.createWorkout.CreateWorkoutViewModel
import com.example.workoutkotlinapp.src.screens.createWorkout.components.exercises.ExerciseItem.ExerciseItem
import kotlinx.coroutines.flow.map

@Composable
fun Exercises() {
    val viewModel: CreateWorkoutViewModel = viewModel()

    val exercises by viewModel.state.map { it.exercises }.collectAsState(initial = listOf())

    Column {
        exercises.forEachIndexed { _, exercise ->
            ExerciseItem(exercise)
        }
    }
}
