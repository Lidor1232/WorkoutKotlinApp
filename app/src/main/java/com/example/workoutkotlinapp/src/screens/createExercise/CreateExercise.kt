package com.example.workoutkotlinapp.src.screens.createExercise

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.workoutkotlinapp.src.screens.createExercise.components.addSet.AddSet
import com.example.workoutkotlinapp.src.screens.createExercise.components.exerciseSets.ExerciseSets
import com.example.workoutkotlinapp.src.screens.createExercise.components.nameInput.NameInput
import com.example.workoutkotlinapp.src.screens.createExercise.components.submitButton.SubmitButton
import com.example.workoutkotlinapp.src.screens.createExercise.components.title.Title

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
