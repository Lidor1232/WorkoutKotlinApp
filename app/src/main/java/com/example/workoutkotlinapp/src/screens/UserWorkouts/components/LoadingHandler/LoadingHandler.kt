package com.example.workoutkotlinapp.src.screens.UserWorkouts.components.LoadingHandler

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.UserWorkouts.UserWorkoutsViewModel
import kotlinx.coroutines.flow.map

@Composable()
fun LoadingHandler() {
    val viewModel: UserWorkoutsViewModel = viewModel()

    val isLoading by viewModel.state.map { it.isLoading }.collectAsState(initial = false)

    if (isLoading) {
        Text(text = "Loading...")
    }
}
