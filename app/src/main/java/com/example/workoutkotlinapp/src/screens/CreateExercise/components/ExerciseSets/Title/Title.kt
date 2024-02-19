package com.example.workoutkotlinapp.src.screens.CreateExercise.components.ExerciseSets.Title

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.CreateExercise.CreateExerciseViewModel
import kotlinx.coroutines.flow.map

@Composable
fun Title() {
    val viewModel: CreateExerciseViewModel = viewModel()

    val sets by viewModel.state.map { it.sets }.collectAsState(initial = listOf())

    if (sets.isNotEmpty()) {
        Text(text = "Sets")
    }
}
