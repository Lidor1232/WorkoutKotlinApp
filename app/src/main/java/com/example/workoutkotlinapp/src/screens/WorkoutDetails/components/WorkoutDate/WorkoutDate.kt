package com.example.workoutkotlinapp.src.screens.WorkoutDetails.components.WorkoutDate

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.WorkoutDetails.WorkoutDetailsViewModel

@Composable
fun WorkoutDate() {
    val workoutDetailsViewModel: WorkoutDetailsViewModel = viewModel()

    val workoutDate by workoutDetailsViewModel.state.map { it.workout?.date }.observeAsState()

    if (workoutDate !== null) {
        Text(text = "Date: $workoutDate")
    }
}
