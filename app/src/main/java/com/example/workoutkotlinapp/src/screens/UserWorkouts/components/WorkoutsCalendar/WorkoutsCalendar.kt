package com.example.workoutkotlinapp.src.screens.UserWorkouts.components.WorkoutsCalendar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.src.screens.UserWorkouts.UserWorkoutsViewModel
import io.github.boguszpawlowski.composecalendar.SelectableCalendar
import io.github.boguszpawlowski.composecalendar.rememberSelectableCalendarState
import io.github.boguszpawlowski.composecalendar.selection.SelectionMode
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter

@Composable
fun WorkoutsCalendar() {
    val viewModel: UserWorkoutsViewModel = viewModel()

    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    val parsedDate = LocalDate.parse("20-01-2020", formatter)

    val calendarState =
        rememberSelectableCalendarState(
            initialMonth = YearMonth.now().plusYears(1),
            initialSelection = listOf(parsedDate),
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
    )
}
