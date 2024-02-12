package com.example.workoutkotlinapp.src.screens.UserWorkouts

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.screens.Login.ErrorHandler
import com.example.workoutkotlinapp.src.screens.UserWorkouts.components.CreateWorkoutButton.CreateWorkoutButton
import com.example.workoutkotlinapp.src.screens.UserWorkouts.components.HandleWorkoutByDate.HandleWorkoutByDate
import com.example.workoutkotlinapp.src.screens.UserWorkouts.components.LoadingHandler.LoadingHandler
import com.example.workoutkotlinapp.src.screens.UserWorkouts.components.WorkoutsCalendar.WorkoutsCalendar

@Composable()
fun UserWorkouts() {
    val viewModel: UserWorkoutsViewModel = viewModel()
    val mainViewModel: MainViewModel = viewModel()

    val token by mainViewModel.state.map { it.token }.observeAsState()

    LaunchedEffect(viewModel) {
        if (token != null) {
            viewModel.getUserWorkouts(token!!)
        }
    }

    Column {
        CreateWorkoutButton()
        Column {
            LoadingHandler()
            ErrorHandler()
            Text(text = "User Workouts")
            WorkoutsCalendar()
            HandleWorkoutByDate()
        }
    }
}
