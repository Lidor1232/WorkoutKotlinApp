package com.example.workoutkotlinapp.src.screens.UserWorkouts.components.LoadingHandler

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.UserWorkouts.UserWorkoutsViewModel

@Composable()
fun LoadingHandler() {
    val viewModel: UserWorkoutsViewModel = viewModel()

    val isLoading by viewModel.state.map { it.isLoading }.observeAsState()

    if (isLoading == true) {
        Text(text = "Loading...")
    }
}