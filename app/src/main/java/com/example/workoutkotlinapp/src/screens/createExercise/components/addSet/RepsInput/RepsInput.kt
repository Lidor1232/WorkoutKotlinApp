package com.example.workoutkotlinapp.src.screens.createExercise.components.addSet.RepsInput

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.createExercise.CreateExerciseIntent
import com.example.workoutkotlinapp.src.screens.createExercise.CreateExerciseViewModel
import kotlinx.coroutines.flow.map

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepsInput() {
    val viewModel: CreateExerciseViewModel = viewModel()

    val reps by viewModel.state.map { it.addSet.reps }.collectAsState(initial = "")

    TextField(
        value = reps,
        onValueChange = {
                text ->
            viewModel.processIntent(CreateExerciseIntent.AddSetUpdateReps(text))
        },
        modifier = Modifier.padding(bottom = 16.dp),
        placeholder = {
            Text("Reps")
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    )
}
