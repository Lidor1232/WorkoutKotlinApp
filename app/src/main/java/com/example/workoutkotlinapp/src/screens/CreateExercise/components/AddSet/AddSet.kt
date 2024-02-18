package com.example.workoutkotlinapp.src.screens.CreateExercise.components.AddSet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.workoutkotlinapp.src.screens.CreateExercise.components.AddSet.RepsInput.RepsInput
import com.example.workoutkotlinapp.src.screens.CreateExercise.components.AddSet.SubmitButton.SubmitButton
import com.example.workoutkotlinapp.src.screens.CreateExercise.components.AddSet.Title.Title
import com.example.workoutkotlinapp.src.screens.CreateExercise.components.AddSet.WeightInput.WeightInput

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
