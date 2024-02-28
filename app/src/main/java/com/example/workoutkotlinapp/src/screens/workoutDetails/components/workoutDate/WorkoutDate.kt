package com.example.workoutkotlinapp.src.screens.workoutDetails.components.workoutDate

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.workoutDetails.WorkoutDetailsViewModel
import kotlinx.coroutines.flow.map

@Composable
fun WorkoutDate() {
    val workoutDetailsViewModel: WorkoutDetailsViewModel = viewModel()

    val workoutDate by workoutDetailsViewModel.state.map { it.workout?.date }.collectAsState(initial = null)

    if (workoutDate !== null) {
        Text(text = "Date: $workoutDate")
    }
}
