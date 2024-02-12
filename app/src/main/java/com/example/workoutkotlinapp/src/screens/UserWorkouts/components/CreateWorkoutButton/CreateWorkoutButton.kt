package com.example.workoutkotlinapp.src.screens.UserWorkouts.components.CreateWorkoutButton

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.MainViewModel

@Composable
fun CreateWorkoutButton() {
    val mainViewModel: MainViewModel = viewModel()

    val mainViewModelController = CreateWorkoutButtonController(mainViewModel = mainViewModel)

    Button(onClick = {
        mainViewModelController.onClick()
    }) {
        Text(text = "Create Workout")
    }
}
