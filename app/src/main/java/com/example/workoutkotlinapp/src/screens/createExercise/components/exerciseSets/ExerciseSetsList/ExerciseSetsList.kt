package com.example.workoutkotlinapp.src.screens.createExercise.components.exerciseSets.ExerciseSetsList

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.createExercise.CreateExerciseViewModel
import kotlinx.coroutines.flow.map

@Composable
fun ExerciseSetsList() {
    val viewModel: CreateExerciseViewModel = viewModel()

    val sets by viewModel.state.map { it.sets }.collectAsState(initial = listOf())

    Column {
        sets.forEachIndexed { index, set ->
            Text(text = "Set number - ${index + 1}: reps ${set.reps}, weight: ${set.weight}")
        }
    }
}
