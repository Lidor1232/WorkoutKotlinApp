package com.example.workoutkotlinapp.src.screens.WorkoutDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.screens.Login.LoginIntent
import com.example.workoutkotlinapp.src.screens.WorkoutDetails.components.BackButton.BackButton
import com.example.workoutkotlinapp.src.screens.WorkoutDetails.components.ErrorHandler.ErrorHandler
import com.example.workoutkotlinapp.src.screens.WorkoutDetails.components.Exercises.Exercises
import com.example.workoutkotlinapp.src.screens.WorkoutDetails.components.LoadingHandler.LoadingHandler
import com.example.workoutkotlinapp.src.screens.WorkoutDetails.components.WorkoutDate.WorkoutDate

@Composable
fun WorkoutDetails() {
    val workoutDetailsViewModel: WorkoutDetailsViewModel = viewModel()
    val mainViewModel: MainViewModel = viewModel()

    val token by mainViewModel.state.map { it.token }.observeAsState()
    val workoutId by workoutDetailsViewModel.state.map { it.workout?._id }.observeAsState()

    DisposableEffect(Unit) {
        onDispose {
            workoutDetailsViewModel.processIntent(WorkoutDetailsIntent.Reset)
        }
    }

    LaunchedEffect(workoutDetailsViewModel) {
        if (token != null && workoutId != null) {
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
