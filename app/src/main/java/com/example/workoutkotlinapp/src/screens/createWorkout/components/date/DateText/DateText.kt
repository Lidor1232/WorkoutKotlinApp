package com.example.workoutkotlinapp.src.screens.createWorkout.components.date.DateText

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.createWorkout.CreateWorkoutViewModel
import kotlinx.coroutines.flow.map

@Composable
fun DateText() {
    val viewModel: CreateWorkoutViewModel = viewModel()

    val date by viewModel.state.map { it.date }.collectAsState(initial = null)

    if (date !== null) {
        Text(text = date.toString())
    }
}
