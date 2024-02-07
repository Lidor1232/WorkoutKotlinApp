package com.example.workoutkotlinapp.src.screens.UserWorkouts

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable()
fun UserWorkouts() {
    val viewModel: UserWorkoutsViewModel = viewModel()
    val state by viewModel.state.observeAsState(UserWorkoutsState())

    LaunchedEffect(viewModel) {
        viewModel.getUserWorkouts()
    }

    LoadingHandler()
    ErrorHandler()
    Title()
    WorkoutsList()
}

@Composable
fun ErrorHandler() {
    val viewModel: UserWorkoutsViewModel = viewModel()
    val state by viewModel.state.observeAsState(UserWorkoutsState())

    if (state.error != null) {
        Text(text = "${state.error}")
    }
}

@Composable()
fun LoadingHandler() {
    val viewModel: UserWorkoutsViewModel = viewModel()
    val state by viewModel.state.observeAsState(UserWorkoutsState())

    if (state.isLoading) {
        Text(text = "Loading...")
    }
}

@Composable
fun Title() {
    Text(text = "User Workouts")
}

@Composable
fun WorkoutsList() {
    val viewModel: UserWorkoutsViewModel = viewModel()
    val state by viewModel.state.observeAsState(UserWorkoutsState())

    LazyColumn {
        items(state.workouts.size) {
                index ->
            Text(text = "Item num: $index, name: ${state.workouts[index].date}")
        }
    }
}
