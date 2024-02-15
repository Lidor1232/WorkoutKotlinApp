package com.example.workoutkotlinapp.src.screens.CreateExercise.components.ExerciseSets.Title

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.CreateExercise.CreateExerciseViewModel

@Composable
fun Title() {
    val viewModel: CreateExerciseViewModel = viewModel()

    val sets by viewModel.state.map { it.sets }.observeAsState()

    if (sets !== null && sets!!.isNotEmpty()) {
        Text(text = "Sets")
    }
}
