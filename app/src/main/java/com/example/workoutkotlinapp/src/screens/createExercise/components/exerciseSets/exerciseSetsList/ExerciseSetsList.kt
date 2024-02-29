package com.example.workoutkotlinapp.src.screens.createExercise.components.exerciseSets.exerciseSetsList

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.createExercise.CreateExerciseViewModel
import kotlinx.coroutines.flow.map
import com.example.workoutkotlinapp.R

@Composable
fun ExerciseSetsList() {
    val viewModel: CreateExerciseViewModel = viewModel()

    val sets by viewModel.state.map { it.sets }.collectAsState(initial = listOf())

    Column {
        sets.forEachIndexed { index, set ->
            Text(text = stringResource(R.string.create_exercise_set_item, index+ 1, set.reps, set.weight))
        }
    }
}
