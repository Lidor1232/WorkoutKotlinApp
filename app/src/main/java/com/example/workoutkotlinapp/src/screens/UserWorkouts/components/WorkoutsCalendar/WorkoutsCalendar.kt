package com.example.workoutkotlinapp.src.screens.UserWorkouts.components.WorkoutsCalendar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.UserWorkouts.UserWorkoutsViewModel
import com.example.workoutkotlinapp.src.screens.UserWorkouts.components.WorkoutsCalendar.DateWithWorkout.DateWithWorkout
import com.example.workoutkotlinapp.src.screens.UserWorkouts.components.WorkoutsCalendar.DateWithoutWorkout.DateWithoutWorkout
import io.github.boguszpawlowski.composecalendar.SelectableCalendar
import io.github.boguszpawlowski.composecalendar.rememberSelectableCalendarState
import io.github.boguszpawlowski.composecalendar.selection.SelectionMode
import java.time.YearMonth

@Composable
fun WorkoutsCalendar() {
    val workoutCalendarController = WorkoutCalendarController()

    val viewModel: UserWorkoutsViewModel = viewModel()

    val workouts by viewModel.state.map { it.workouts }.observeAsState()

    val calendarState =
        rememberSelectableCalendarState(
            initialMonth = YearMonth.now(),
            initialSelectionMode = SelectionMode.Single,
        )

    LaunchedEffect(calendarState.selectionState) {
        snapshotFlow { calendarState.selectionState.selection }
            .collect { selection ->
                viewModel.handleDateSelection(selection)
            }
    }

    SelectableCalendar(
        calendarState = calendarState,
        dayContent = {
                dayState ->
            val isDateHasWorkout =
                workoutCalendarController.isDateHasWorkout(
                    dayState.date,
                    workouts,
                )

            if (isDateHasWorkout) {
                DateWithWorkout(dayState)
            } else {
                DateWithoutWorkout(dayState)
            }
        },
    )
}
