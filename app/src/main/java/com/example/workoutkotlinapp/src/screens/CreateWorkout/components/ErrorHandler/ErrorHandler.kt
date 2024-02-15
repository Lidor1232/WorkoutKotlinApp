package com.example.workoutkotlinapp.src.screens.CreateWorkout.components.ErrorHandler

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.CreateWorkout.CreateWorkoutViewModel

@Composable
fun ErrorHandler() {
    val createWorkoutViewModel: CreateWorkoutViewModel = viewModel()

    val error by createWorkoutViewModel.state.map { it.error }.observeAsState()

    if (error !== null) {
        Text(text = error!!)
    }
}
