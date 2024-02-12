package com.example.workoutkotlinapp.src.screens.UserWorkouts.components.HandleWorkoutByDate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.UserWorkouts.UserWorkoutsViewModel
import com.example.workoutkotlinapp.src.screens.UserWorkouts.components.HandleWorkoutByDate.NoWorkoutByDate.NoWorkoutByDate
import com.example.workoutkotlinapp.src.screens.UserWorkouts.components.HandleWorkoutByDate.WorkoutByDate.WorkoutByDate
import com.example.workoutkotlinapp.src.utils.Workout.WorkoutUtil
import timber.log.Timber

@Composable
fun HandleWorkoutByDate() {
    val viewModel: UserWorkoutsViewModel = viewModel()

    val selectedDate by viewModel.state.map { it.selectedDate }.observeAsState()
    val workouts by viewModel.state.map { it.workouts }.observeAsState()

    val workout =
        if (workouts != null && selectedDate != null) {
            WorkoutUtil.getWorkoutByDate(
                workouts = workouts!!,
                date = selectedDate!!,
            )
        } else {
            null
        }

    Timber.d("WORKOUTHEY $workout")

    if (workout !== null) {
        WorkoutByDate()
    } else {
        NoWorkoutByDate()
    }
}
