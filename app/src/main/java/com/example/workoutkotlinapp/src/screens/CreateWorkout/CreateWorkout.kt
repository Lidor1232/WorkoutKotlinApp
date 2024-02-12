package com.example.workoutkotlinapp.src.screens.CreateWorkout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.ActiveScreen
import com.example.workoutkotlinapp.MainIntent
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.utils.Date.DateUtil

@Composable
fun CreateWorkout() {
    Column(
        modifier =
            Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Title()
        DateText()
        DateInput()
        Exercises()
        AddExerciseButton()
        SubmitButton()
    }
}

@Composable
fun Title() {
    Text(text = "Create Workout")
}

@Composable()
fun DateText() {
    val viewModel: CreateWorkoutViewModel = viewModel()

    val date by viewModel.state.map { it.date }.observeAsState()

    if (date !== null) {
        Text(text = date.toString())
    }
}

@Composable
fun DateInput() {
    val viewModel: CreateWorkoutViewModel = viewModel()

    val context = LocalContext.current
    Button(onClick = {
        DateUtil.showDatePicker(context) { date ->
            viewModel.processIntent(CreateWorkoutIntent.SetDate(date))
        }
    }) {
        Text("Select Date")
    }
}

@Composable
fun Exercises() {
    val viewModel: CreateWorkoutViewModel = viewModel()

    val exercises by viewModel.state.map { it.exercises }.observeAsState()

    if (exercises !== null) {
        Column {
            exercises!!.forEachIndexed { index, exercise ->
                Text(text = "Exercise num ${index + 1}")
            }
        }
    }
}

@Composable
fun AddExerciseButton() {
    val viewModel: MainViewModel = viewModel()

    Button(onClick = {
        viewModel.processIntent(MainIntent.SetActiveScreen(ActiveScreen.CreateExercise))
    }) {
        Text(text = "Add Exercise")
    }
}

@Composable
fun SubmitButton() {
    Button(onClick = { }) {
        Text(text = "Submit")
    }
}
