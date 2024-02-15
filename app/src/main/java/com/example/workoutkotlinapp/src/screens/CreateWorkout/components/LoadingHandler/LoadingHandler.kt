package com.example.workoutkotlinapp.src.screens.CreateWorkout.components.LoadingHandler

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.CreateWorkout.CreateWorkoutViewModel

@Composable
fun LoadingHandler() {
    val createWorkoutViewModel: CreateWorkoutViewModel = viewModel()

    val isLoading by createWorkoutViewModel.state.map { it.isLoading }.observeAsState()

    if (isLoading === true) {
        Text(text = "Loading...")
    }
}
