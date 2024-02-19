package com.example.workoutkotlinapp.src.screens.CreateWorkout.components.Date.DateInput

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.CreateWorkout.CreateWorkoutIntent
import com.example.workoutkotlinapp.src.screens.CreateWorkout.CreateWorkoutViewModel
import com.example.workoutkotlinapp.src.utils.Date.DateUtil

@Composable
fun DateInput() {
    val context = LocalContext.current

    val viewModel: CreateWorkoutViewModel = viewModel()

    Button(onClick = {
        DateUtil.showDatePicker(context) { date ->
            viewModel.processIntent(CreateWorkoutIntent.SetDate(date))
        }
    }) {
        Text("Select Date")
    }
}
