package com.example.workoutkotlinapp.src.screens.UserWorkouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.screens.UserWorkouts.components.CreateWorkoutButton.CreateWorkoutButton
import com.example.workoutkotlinapp.src.screens.UserWorkouts.components.ErrorHandler.ErrorHandler
import com.example.workoutkotlinapp.src.screens.UserWorkouts.components.LoadingHandler.LoadingHandler
import com.example.workoutkotlinapp.src.screens.UserWorkouts.components.LogoutButton.LogoutButton
import com.example.workoutkotlinapp.src.screens.UserWorkouts.components.WorkoutsCalendar.WorkoutsCalendar

@Composable()
fun UserWorkouts() {
    val userWorkoutsViewModel: UserWorkoutsViewModel = viewModel()
    val mainViewModel: MainViewModel = viewModel()

    val token by mainViewModel.state.map { it.token }.observeAsState()

    DisposableEffect(Unit) {
        onDispose {
            userWorkoutsViewModel.processIntent(UserWorkoutsIntent.Reset)
        }
    }

    LaunchedEffect(Unit) {
        if (token != null) {
            userWorkoutsViewModel.getUserWorkouts(token!!)
        }
    }

    Column(
        modifier =
            Modifier
                .fillMaxSize(),
    ) {
        CreateWorkoutButton()
        LogoutButton()
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
        ) {
            LoadingHandler()
            ErrorHandler()
            WorkoutsCalendar()
        }
    }
}
