package com.example.workoutkotlinapp.src.screens.workoutDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.screens.workoutDetails.components.backButton.BackButton
import com.example.workoutkotlinapp.src.screens.workoutDetails.components.errorHandler.ErrorHandler
import com.example.workoutkotlinapp.src.screens.workoutDetails.components.exercises.Exercises
import com.example.workoutkotlinapp.src.screens.workoutDetails.components.loadingHandler.LoadingHandler
import com.example.workoutkotlinapp.src.screens.workoutDetails.components.workoutDate.WorkoutDate
import kotlinx.coroutines.flow.map

@Composable
fun WorkoutDetails() {
    val workoutDetailsViewModel: WorkoutDetailsViewModel = viewModel()
    val mainViewModel: MainViewModel = viewModel()

    val token by mainViewModel.state.map { it.token }.collectAsState(initial = null)
    val workoutId by workoutDetailsViewModel.state.map { it.workout?.id }.collectAsState(initial = null)

    DisposableEffect(Unit) {
        onDispose {
            workoutDetailsViewModel.processIntent(WorkoutDetailsIntent.Reset)
        }
    }

    LaunchedEffect(Unit) {
        if (token !== null && workoutId !== null) {
            workoutDetailsViewModel.getExercises(token = token!!, workoutId = workoutId!!)
        }
    }

    Column {
        BackButton()
        WorkoutDate()
        LoadingHandler()
        ErrorHandler()
        Exercises()
    }
}
