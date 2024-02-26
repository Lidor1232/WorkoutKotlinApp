package com.example.workoutkotlinapp.src.screens.userWorkouts.components.workoutsCalendar.calendarDay

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.userWorkouts.UserWorkoutsViewModel
import com.example.workoutkotlinapp.src.screens.userWorkouts.components.workoutsCalendar.calendarDay.dateWithWorkout.DateWithWorkout
import com.example.workoutkotlinapp.src.screens.userWorkouts.components.workoutsCalendar.calendarDay.dateWithoutWorkout.DateWithoutWorkout
import io.github.boguszpawlowski.composecalendar.day.DayState
import io.github.boguszpawlowski.composecalendar.selection.DynamicSelectionState
import kotlinx.coroutines.flow.map

@Composable
fun CalendarDay(dayState: DayState<DynamicSelectionState>) {
    val userWorkoutsViewModel: UserWorkoutsViewModel = viewModel()

    val calendarDayController = CalendarDayController()

    val workouts by userWorkoutsViewModel.state.map { it.workouts }.collectAsState(initial = listOf())

    val workout =
        calendarDayController.getWorkoutByDate(
            dayState.date,
            workouts,
        )

    if (workout !== null) {
        DateWithWorkout(dayState, workout)
    } else {
        DateWithoutWorkout(dayState)
    }
}
