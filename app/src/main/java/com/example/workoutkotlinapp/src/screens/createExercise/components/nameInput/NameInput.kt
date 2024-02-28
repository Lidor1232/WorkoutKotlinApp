package com.example.workoutkotlinapp.src.screens.createExercise.components.nameInput

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.createExercise.CreateExerciseIntent
import com.example.workoutkotlinapp.src.screens.createExercise.CreateExerciseViewModel
import kotlinx.coroutines.flow.map

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NameInput() {
    val createExerciseViewModel: CreateExerciseViewModel = viewModel()

    val nameInputController = NameInputController(createExerciseViewModel)

    val name by createExerciseViewModel.state.map { it.name }.collectAsState(initial = "")

    TextField(
        modifier =
            Modifier.padding(bottom = 16.dp),
        value = name,
        onValueChange = {
                text ->
            nameInputController.onChangeNameInput(text)
        },
        placeholder = {
            Text("Exercise Name")
        },
    )
}
