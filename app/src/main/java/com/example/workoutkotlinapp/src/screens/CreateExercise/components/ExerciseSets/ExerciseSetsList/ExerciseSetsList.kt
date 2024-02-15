package com.example.workoutkotlinapp.src.screens.CreateExercise.components.ExerciseSets.ExerciseSetsList

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.CreateExercise.CreateExerciseViewModel

@Composable
fun ExerciseSetsList() {
    val viewModel: CreateExerciseViewModel = viewModel()

    val sets by viewModel.state.map { it.sets }.observeAsState()

    if (sets !== null) {
        Column {
            sets!!.forEachIndexed { index, set ->
                Text(text = "Set number - ${index + 1}: reps ${set.reps}, weight: ${set.weight}")
            }
        }
    }
}
