package com.example.workoutkotlinapp.src.screens.CreateExercise

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.CreateExercise.AddSet.AddSet

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
    }
}

@Preview
@Composable
fun CreateExercisePreview() {
    CreateExercise()
}

@Composable
fun Title() {
    Text(
        text = "Create Exercise",
        modifier = Modifier.padding(bottom = 16.dp),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NameInput() {
    val viewModel: CreateExerciseViewModel = viewModel()

    val name by viewModel.state.map { it.name }.observeAsState()

    if (name !== null) {
        TextField(
            value = name!!,
            onValueChange = {
                    text ->
                viewModel.processIntent(CreateExerciseIntent.SetName(text))
            },
            modifier =
                Modifier.padding(bottom = 16.dp),
            placeholder = {
                Text("Exercise Name")
            }
        )
    }
}

@Composable
fun ExerciseSets() {
    val viewModel: CreateExerciseViewModel = viewModel()

    val sets by viewModel.state.map { it.sets }.observeAsState()

    if (sets !== null) {
        Column () {

            sets!!.forEachIndexed { index, set ->
                Text(text = "Set ${index + 1}") // Adding 1 because index starts at 0
            }
        }
    }
}

// @Composable
// fun AddSet() {
// }
