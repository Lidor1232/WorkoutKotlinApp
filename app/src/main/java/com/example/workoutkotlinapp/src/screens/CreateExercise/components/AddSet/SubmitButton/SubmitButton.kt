package com.example.workoutkotlinapp.src.screens.CreateExercise.components.AddSet.SubmitButton

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.CreateExercise.CreateExerciseIntent
import com.example.workoutkotlinapp.src.screens.CreateExercise.CreateExerciseViewModel
import com.example.workoutkotlinapp.src.types.ExerciseSet
import kotlinx.coroutines.flow.map

@Composable
fun SubmitButton() {
    val createExerciseViewModel: CreateExerciseViewModel = viewModel()
    val weight by createExerciseViewModel.state.map { it.addSet.weight }.collectAsState(initial = "")
    val reps by createExerciseViewModel.state.map { it.addSet.reps }.collectAsState(initial = "")

    Button(onClick = {
        createExerciseViewModel.processIntent(
            CreateExerciseIntent.AddSet(
                set = ExerciseSet(weight = weight.toInt(), reps = reps.toInt()),
            ),
        )
        createExerciseViewModel.processIntent(CreateExerciseIntent.AddSetReset)
        createExerciseViewModel.processIntent(CreateExerciseIntent.AddSetReset)
    }) {
        Text(text = "Add Set")
    }
}
