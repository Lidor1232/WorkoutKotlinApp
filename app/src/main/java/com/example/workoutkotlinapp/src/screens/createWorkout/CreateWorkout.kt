package com.example.workoutkotlinapp.src.screens.createWorkout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.components.Buttons.BackButton.BackButton
import com.example.workoutkotlinapp.src.screens.createWorkout.components.addExerciseButton.AddExerciseButton
import com.example.workoutkotlinapp.src.screens.createWorkout.components.date.Date
import com.example.workoutkotlinapp.src.screens.createWorkout.components.errorHandler.ErrorHandler
import com.example.workoutkotlinapp.src.screens.createWorkout.components.exercises.Exercises
import com.example.workoutkotlinapp.src.screens.createWorkout.components.loadingHandler.LoadingHandler
import com.example.workoutkotlinapp.src.screens.createWorkout.components.submitButton.SubmitButton
import com.example.workoutkotlinapp.src.screens.createWorkout.components.title.Title

@Composable
fun CreateWorkout() {
    val mainViewModel: MainViewModel = viewModel()
    val createWorkoutViewModel: CreateWorkoutViewModel = viewModel()

    val createWorkoutController =
        CreateWorkoutController(
            mainViewModel,
            createWorkoutViewModel,
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
