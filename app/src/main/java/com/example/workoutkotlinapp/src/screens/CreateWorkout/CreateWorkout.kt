package com.example.workoutkotlinapp.src.screens.CreateWorkout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.workoutkotlinapp.src.screens.CreateWorkout.components.AddExerciseButton.AddExerciseButton
import com.example.workoutkotlinapp.src.screens.CreateWorkout.components.Date.Date
import com.example.workoutkotlinapp.src.screens.CreateWorkout.components.Exercises.Exercises
import com.example.workoutkotlinapp.src.screens.CreateWorkout.components.SubmitButton.SubmitButton
import com.example.workoutkotlinapp.src.screens.CreateWorkout.components.Title.Title

@Composable
fun CreateWorkout() {
    Column(
        modifier =
            Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Title()
        Date()
        Exercises()
        AddExerciseButton()
        SubmitButton()
    }
}
