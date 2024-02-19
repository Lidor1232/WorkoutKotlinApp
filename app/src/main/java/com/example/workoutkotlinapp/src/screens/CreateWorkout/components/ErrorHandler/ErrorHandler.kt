package com.example.workoutkotlinapp.src.screens.CreateWorkout.components.ErrorHandler

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.CreateWorkout.CreateWorkoutViewModel
import kotlinx.coroutines.flow.map

@Composable
fun ErrorHandler() {
    val createWorkoutViewModel: CreateWorkoutViewModel = viewModel()

    val error by createWorkoutViewModel.state.map { it.error }.collectAsState(initial = null)

    if (error !== null) {
        Text(text = error!!)
    }
}
