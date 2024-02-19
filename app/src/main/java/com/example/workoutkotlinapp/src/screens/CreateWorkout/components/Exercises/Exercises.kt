package com.example.workoutkotlinapp.src.screens.CreateWorkout.components.Exercises

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.CreateWorkout.CreateWorkoutViewModel
import com.example.workoutkotlinapp.src.screens.CreateWorkout.components.Exercises.ExerciseItem.ExerciseItem
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
