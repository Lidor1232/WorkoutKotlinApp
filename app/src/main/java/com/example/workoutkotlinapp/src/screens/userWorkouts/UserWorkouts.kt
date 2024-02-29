package com.example.workoutkotlinapp.src.screens.userWorkouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.screens.userWorkouts.components.createWorkoutButton.CreateWorkoutButton
import com.example.workoutkotlinapp.src.screens.userWorkouts.components.errorHandler.ErrorHandler
import com.example.workoutkotlinapp.src.screens.userWorkouts.components.loadingHandler.LoadingHandler
import com.example.workoutkotlinapp.src.screens.userWorkouts.components.logoutButton.LogoutButton
import com.example.workoutkotlinapp.src.screens.userWorkouts.components.workoutsCalendar.WorkoutsCalendar
import kotlinx.coroutines.flow.map

@Composable()
fun UserWorkouts() {
    val userWorkoutsViewModel: UserWorkoutsViewModel = viewModel()
    val mainViewModel: MainViewModel = viewModel()

    val token by mainViewModel.state.map { it.token }.collectAsState(initial = null)
    val userId by mainViewModel.state.map { it.getUser.user?.id }.collectAsState(initial = null)

    DisposableEffect(Unit) {
        onDispose {
            userWorkoutsViewModel.processIntent(UserWorkoutsIntent.Reset)
        }
    }

    LaunchedEffect(Unit) {
        if (token !== null && userId !== null) {
            userWorkoutsViewModel.getUserWorkouts(token!!, userId!!)
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
