package com.example.workoutkotlinapp.src.screens.userWorkouts.components.workoutsCalendar.calendarDay.dateWithWorkout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.screens.workoutDetails.WorkoutDetailsViewModel
import com.example.workoutkotlinapp.src.types.Workout
import io.github.boguszpawlowski.composecalendar.day.DayState
import io.github.boguszpawlowski.composecalendar.selection.DynamicSelectionState

@Composable
fun DateWithWorkout(
    dayState: DayState<DynamicSelectionState>,
    workout: Workout,
) {
    val mainViewModel: MainViewModel = viewModel()
    val workoutDetailsViewModel: WorkoutDetailsViewModel = viewModel()

    val dateWithWorkoutController = DateWithWorkoutController(mainViewModel, workoutDetailsViewModel)

    Text(
        modifier =
            Modifier.padding(16.dp).clickable {
                dateWithWorkoutController.onClick(workout)
            },
        text = dayState.date.dayOfMonth.toString(),
        color = Color.Blue,
    )
}
