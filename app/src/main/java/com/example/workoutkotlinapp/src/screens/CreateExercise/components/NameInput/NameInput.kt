package com.example.workoutkotlinapp.src.screens.CreateExercise.components.NameInput

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.CreateExercise.CreateExerciseIntent
import com.example.workoutkotlinapp.src.screens.CreateExercise.CreateExerciseViewModel

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
            },
        )
    }
}
