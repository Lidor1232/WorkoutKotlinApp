package com.example.workoutkotlinapp.src.screens.UserWorkouts.components.ErrorHandler

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.UserWorkouts.UserWorkoutsViewModel

@Composable
fun ErrorHandler() {
    val viewModel: UserWorkoutsViewModel = viewModel()

    val error by viewModel.state.map { it.error }.observeAsState()

    if (error != null) {
        Text(text = "$error")
    }
}
