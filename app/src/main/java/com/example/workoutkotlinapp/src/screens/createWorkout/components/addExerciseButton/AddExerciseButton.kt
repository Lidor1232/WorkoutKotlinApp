package com.example.workoutkotlinapp.src.screens.createWorkout.components.addExerciseButton

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.ActiveScreen
import com.example.workoutkotlinapp.MainIntent
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.R

@Composable
fun AddExerciseButton() {
    val mainViewModel: MainViewModel = viewModel()

    val addExerciseButtonController = AddExerciseButtonController(mainViewModel)

    Button(onClick = {
        addExerciseButtonController.onClick()
    }) {
        Text(text = stringResource(R.string.create_workout_add_exercise_button))
    }
}
