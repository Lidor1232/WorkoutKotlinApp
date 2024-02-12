package com.example.workoutkotlinapp.src.screens.CreateWorkout.components.Exercises

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.CreateWorkout.CreateWorkoutViewModel

@Composable
fun Exercises() {
    val viewModel: CreateWorkoutViewModel = viewModel()

    val exercises by viewModel.state.map { it.exercises }.observeAsState()

    if (exercises !== null) {
        Column {
            exercises!!.forEachIndexed { index, exercise ->
                Text(text = "Exercise num ${index + 1}")
            }
        }
    }
}