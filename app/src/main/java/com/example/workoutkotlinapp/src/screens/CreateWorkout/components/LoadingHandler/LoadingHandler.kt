package com.example.workoutkotlinapp.src.screens.CreateWorkout.components.LoadingHandler

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.CreateWorkout.CreateWorkoutViewModel
import kotlinx.coroutines.flow.map

@Composable
fun LoadingHandler() {
    val createWorkoutViewModel: CreateWorkoutViewModel = viewModel()

    val isLoading by createWorkoutViewModel.state.map { it.isLoading }.collectAsState(initial = false)

    if (isLoading) {
        Text(text = "Loading...")
    }
}
