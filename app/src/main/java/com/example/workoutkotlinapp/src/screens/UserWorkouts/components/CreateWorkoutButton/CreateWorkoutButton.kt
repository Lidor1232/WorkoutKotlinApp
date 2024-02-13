package com.example.workoutkotlinapp.src.screens.UserWorkouts.components.CreateWorkoutButton

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.MainViewModel

@Composable
fun CreateWorkoutButton() {
    val mainViewModel: MainViewModel = viewModel()

    val mainViewModelController = CreateWorkoutButtonController(mainViewModel = mainViewModel)

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = {
            mainViewModelController.onClick()
        }) {
            Text(text = "Create Workout")
        }
    }
}
