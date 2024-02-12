package com.example.workoutkotlinapp.src.screens.CreateWorkout.components.SubmitButton

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.screens.CreateWorkout.CreateWorkoutViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
fun SubmitButton() {
    val createWorkoutViewModel: CreateWorkoutViewModel = viewModel()
    val mainViewModel: MainViewModel = viewModel()

    val submitButtonController =
        SubmitButtonController(
            createWorkoutViewModel = createWorkoutViewModel,
            mainViewModel = mainViewModel,
        )

    val date by createWorkoutViewModel.state.map { it.date }.observeAsState()
    val exercises by createWorkoutViewModel.state.map { it.exercises }.observeAsState()
    val userToken by mainViewModel.state.map { it.token }.observeAsState()

    val coroutineScope = rememberCoroutineScope()

    Button(onClick = {
        coroutineScope.launch {
            submitButtonController.onSubmit(
                date = date,
                exercises = exercises!!,
                userToken = userToken!!,
            )
        }
    }) {
        Text(text = "Submit")
    }
}
