package com.example.workoutkotlinapp.src.screens.createWorkout.components.errorHandler

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.components.ErrorMessage.ErrorMessage
import com.example.workoutkotlinapp.src.screens.createWorkout.CreateWorkoutViewModel
import kotlinx.coroutines.flow.map

@Composable
fun ErrorHandler() {
    val createWorkoutViewModel: CreateWorkoutViewModel = viewModel()

    val error by createWorkoutViewModel.state.map { it.error }.collectAsState(initial = null)

    if (error !== null) {
        ErrorMessage(error.toString())
    }
}
