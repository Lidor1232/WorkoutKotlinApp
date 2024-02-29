package com.example.workoutkotlinapp.src.screens.createWorkout.components.submitButton

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.screens.createWorkout.CreateWorkoutViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import com.example.workoutkotlinapp.R

@Composable
fun SubmitButton() {
    val createWorkoutViewModel: CreateWorkoutViewModel = viewModel()
    val mainViewModel: MainViewModel = viewModel()

    val submitButtonController =
        SubmitButtonController(
            createWorkoutViewModel = createWorkoutViewModel,
            mainViewModel = mainViewModel,
        )

    val date by createWorkoutViewModel.state.map { it.date }.collectAsState(initial = null)
    val exercises by createWorkoutViewModel.state.map { it.exercises }.collectAsState(initial = listOf())
    val token by mainViewModel.state.map { it.token }.collectAsState(initial = null)

    val coroutineScope = rememberCoroutineScope()

    Button(onClick = {
        coroutineScope.launch {
            submitButtonController.onSubmit(
                date = date,
                exercises = exercises,
                userToken = token,
            )
        }
    }) {
        Text(text = stringResource(R.string.create_workout_submit_button))
    }
}
