package com.example.workoutkotlinapp.src.screens.workoutDetails.components.errorHandler

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.components.ErrorMessage.ErrorMessage
import com.example.workoutkotlinapp.src.screens.userWorkouts.UserWorkoutsViewModel
import kotlinx.coroutines.flow.map

@Composable
fun ErrorHandler() {
    val viewModel: UserWorkoutsViewModel = viewModel()

    val error by viewModel.state.map { it.error }.collectAsState(initial = null)

    if (error !== null) {
        ErrorMessage(error = error!!)
    }
}
