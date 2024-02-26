package com.example.workoutkotlinapp.src.screens.workoutDetails.components.backButton

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.MainViewModel

@Composable
fun BackButton() {
    val mainViewModel: MainViewModel = viewModel()

    val backButtonController = BackButtonController(mainViewModel)

    Button(onClick = {
        backButtonController.onClick()
    }) {
        Text(text = "Back")
    }
}
