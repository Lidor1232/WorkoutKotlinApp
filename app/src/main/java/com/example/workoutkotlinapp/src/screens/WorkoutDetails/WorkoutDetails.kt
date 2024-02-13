package com.example.workoutkotlinapp.src.screens.WorkoutDetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.MainViewModel

@Composable
fun WorkoutDetails() {
    val workoutDetailsViewModel: WorkoutDetailsViewModel = viewModel()
    val mainViewModel: MainViewModel = viewModel()

    val token by mainViewModel.state.map { it.token }.observeAsState()
    val workoutId by workoutDetailsViewModel.state.map { it.workout?._id }.observeAsState()

    LaunchedEffect(workoutDetailsViewModel) {
        if (token != null && workoutId != null) {
            workoutDetailsViewModel.getExercises(token = token!!, workoutId = workoutId!!)
        }
    }
}
