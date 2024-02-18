package com.example.workoutkotlinapp.src.screens.CreateExercise.components.AddSet.WeightInput

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
import com.example.workoutkotlinapp.src.screens.CreateExercise.CreateExerciseIntent
import com.example.workoutkotlinapp.src.screens.CreateExercise.CreateExerciseViewModel
import kotlinx.coroutines.flow.map

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeightInput() {
    val viewModel: CreateExerciseViewModel = viewModel()

    val weight by viewModel.state.map { it.addSet.weight }.collectAsState(initial = "")

    TextField(
        modifier = Modifier.padding(bottom = 16.dp),
        value = weight,
        onValueChange = {
                text ->
            viewModel.processIntent(CreateExerciseIntent.AddSetUpdateWeight(text))
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        placeholder = {
            Text("Weight")
        },
    )
}
