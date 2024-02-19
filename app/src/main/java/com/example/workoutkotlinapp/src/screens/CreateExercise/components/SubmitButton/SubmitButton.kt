package com.example.workoutkotlinapp.src.screens.CreateExercise.components.SubmitButton

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.screens.CreateExercise.CreateExerciseController
import com.example.workoutkotlinapp.src.screens.CreateExercise.CreateExerciseViewModel
import com.example.workoutkotlinapp.src.screens.CreateWorkout.CreateWorkoutViewModel
import kotlinx.coroutines.flow.map

@Composable
fun SubmitButton() {
    val createExerciseViewModel: CreateExerciseViewModel = viewModel()
    val createWorkoutViewModel: CreateWorkoutViewModel = viewModel()
    val mainViewModel: MainViewModel = viewModel()

    val createExerciseController =
        CreateExerciseController(mainViewModel, createWorkoutViewModel, createExerciseViewModel)

    val name by createExerciseViewModel.state.map { it.name }.collectAsState(initial = "")
    val sets by createExerciseViewModel.state.map { it.sets }.collectAsState(initial = listOf())

    Spacer(modifier = Modifier.height(40.dp))
    Button(onClick = {
        createExerciseController.onSubmit(name, sets)
    }) {
        Text(text = "Submit")
    }
}
