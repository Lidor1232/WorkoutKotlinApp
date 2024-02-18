package com.example.workoutkotlinapp.src.screens.UserWorkouts.components.WorkoutsCalendar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.UserWorkouts.UserWorkoutsViewModel
import com.example.workoutkotlinapp.src.screens.UserWorkouts.components.WorkoutsCalendar.CalendarDay.CalendarDay
import io.github.boguszpawlowski.composecalendar.SelectableCalendar
import io.github.boguszpawlowski.composecalendar.rememberSelectableCalendarState
import io.github.boguszpawlowski.composecalendar.selection.SelectionMode
import java.time.YearMonth

@Composable
fun WorkoutsCalendar() {
    val viewModel: UserWorkoutsViewModel = viewModel()

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
            CalendarDay(dayState)
        },
    )
}
