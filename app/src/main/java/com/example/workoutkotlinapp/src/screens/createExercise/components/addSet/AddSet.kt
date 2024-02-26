package com.example.workoutkotlinapp.src.screens.createExercise.components.addSet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.workoutkotlinapp.src.screens.createExercise.components.addSet.RepsInput.RepsInput
import com.example.workoutkotlinapp.src.screens.createExercise.components.addSet.SubmitButton.SubmitButton
import com.example.workoutkotlinapp.src.screens.createExercise.components.addSet.Title.Title
import com.example.workoutkotlinapp.src.screens.createExercise.components.addSet.WeightInput.WeightInput

@Composable
fun AddSet() {
    Column {
        Title()
        Row {
            RepsInput()
            Spacer(modifier = Modifier.width(16.dp))
            WeightInput()
        }
        SubmitButton()
    }
}
