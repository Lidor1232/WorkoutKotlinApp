package com.example.workoutkotlinapp.src.screens.CreateExercise.AddSet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.CreateExercise.CreateExerciseIntent
import com.example.workoutkotlinapp.src.screens.CreateExercise.CreateExerciseViewModel
import com.example.workoutkotlinapp.src.types.ExerciseSet

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

@Composable
fun Title() {
    Text(text = "Add New Set", modifier = Modifier.padding(bottom = 16.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepsInput() {
    val viewModel: CreateExerciseViewModel = viewModel()

    val reps by viewModel.state.map { it.addSet.reps }.observeAsState()

    if (reps !== null) {
        TextField(
            value = reps!!,
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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeightInput() {
    val viewModel: CreateExerciseViewModel = viewModel()

    val weight by viewModel.state.map { it.addSet.weight }.observeAsState()

    if (weight !== null) {
        TextField(
            value = weight!!,
            onValueChange = {
                    text ->
                viewModel.processIntent(CreateExerciseIntent.AddSetUpdateWeight(text))
            },
            modifier = Modifier.padding(bottom = 16.dp),
            placeholder = {
                Text("Weight")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )
    }
}

@Composable
fun SubmitButton() {
    val createExerciseViewModel: CreateExerciseViewModel = viewModel()
    val weight by createExerciseViewModel.state.map { it.addSet.weight }.observeAsState()
    val reps by createExerciseViewModel.state.map { it.addSet.reps }.observeAsState()

    Button(onClick = {
        if (weight !== null && reps !== null) {
            createExerciseViewModel.processIntent(
                CreateExerciseIntent.AddSet(
                    set = ExerciseSet(weight = weight!!.toInt(), reps = reps!!.toInt()),
                ),
            )
        }
        createExerciseViewModel.processIntent(CreateExerciseIntent.AddSetReset)
    }) {
        Text(text = "Add Set")
    }
}
