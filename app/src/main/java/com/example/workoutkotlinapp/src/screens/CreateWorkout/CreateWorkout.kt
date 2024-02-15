package com.example.workoutkotlinapp.src.screens.CreateWorkout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.components.Buttons.BackButton.BackButton
import com.example.workoutkotlinapp.src.screens.CreateWorkout.components.AddExerciseButton.AddExerciseButton
import com.example.workoutkotlinapp.src.screens.CreateWorkout.components.Date.Date
import com.example.workoutkotlinapp.src.screens.CreateWorkout.components.ErrorHandler.ErrorHandler
import com.example.workoutkotlinapp.src.screens.CreateWorkout.components.Exercises.Exercises
import com.example.workoutkotlinapp.src.screens.CreateWorkout.components.LoadingHandler.LoadingHandler
import com.example.workoutkotlinapp.src.screens.CreateWorkout.components.SubmitButton.SubmitButton
import com.example.workoutkotlinapp.src.screens.CreateWorkout.components.Title.Title

@Composable
fun CreateWorkout() {
    val mainViewModel: MainViewModel = viewModel()

    val createWorkoutController =
        CreateWorkoutController(
            mainViewModel,
        )

    Column {
        BackButton(
            onClick = { createWorkoutController.goBack() },
        )
        Column(
            modifier =
                Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            LoadingHandler()
            ErrorHandler()
            Title()
            Date()
            Exercises()
            AddExerciseButton()
            SubmitButton()
        }
    }
}
