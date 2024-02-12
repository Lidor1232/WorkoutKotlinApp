package com.example.workoutkotlinapp.src.screens.CreateExercise

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.workoutkotlinapp.src.screens.CreateExercise.components.AddSet.AddSet
import com.example.workoutkotlinapp.src.screens.CreateExercise.components.ExerciseSets.ExerciseSets
import com.example.workoutkotlinapp.src.screens.CreateExercise.components.NameInput.NameInput
import com.example.workoutkotlinapp.src.screens.CreateExercise.components.SubmitButton.SubmitButton
import com.example.workoutkotlinapp.src.screens.CreateExercise.components.Title.Title

@Composable
fun CreateExercise() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Title()
        NameInput()
        ExerciseSets()
        AddSet()
        SubmitButton()
    }
}
