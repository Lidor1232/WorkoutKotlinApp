package com.example.workoutkotlinapp.src.screens.CreateWorkout.components.Date.DateText

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.CreateWorkout.CreateWorkoutViewModel

@Composable
fun DateText() {
    val viewModel: CreateWorkoutViewModel = viewModel()

    val date by viewModel.state.map { it.date }.observeAsState()

    if (date !== null) {
        Text(text = date.toString())
    }
}
