package com.example.workoutkotlinapp.src.screens.UserWorkouts

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.map
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutkotlinapp.MainState
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.utils.Workout.WorkoutUtil
import io.github.boguszpawlowski.composecalendar.SelectableCalendar
import io.github.boguszpawlowski.composecalendar.rememberSelectableCalendarState
import io.github.boguszpawlowski.composecalendar.selection.SelectionMode
import timber.log.Timber
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter

@Composable()
fun UserWorkouts() {
    val viewModel: UserWorkoutsViewModel = viewModel()
    val mainViewModel: MainViewModel = viewModel()
    val mainState by mainViewModel.state.observeAsState(MainState())

    LaunchedEffect(viewModel) {
        if (mainState.token != null) {
            viewModel.getUserWorkouts(mainState.token!!)
        }
    }

    Column {
        LoadingHandler()
        ErrorHandler()
        Title()
        WorkoutsCalendar()
        HandleWorkoutByDate()
    }
}

@Composable
fun ErrorHandler() {
    val viewModel: UserWorkoutsViewModel = viewModel()
    val state by viewModel.state.observeAsState(UserWorkoutsState())

    if (state.error != null) {
        Text(text = "${state.error}")
    }
}

@Composable()
fun LoadingHandler() {
    val viewModel: UserWorkoutsViewModel = viewModel()
    val state by viewModel.state.observeAsState(UserWorkoutsState())

    if (state.isLoading) {
        Text(text = "Loading...")
    }
}

@Composable
fun Title() {
    Text(text = "User Workouts")
}

@Composable
fun WorkoutsCalendar() {
    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    val parsedDate = LocalDate.parse("20-01-2020", formatter)
    val viewModel: UserWorkoutsViewModel = viewModel()

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

@Composable
fun WorkoutByDate() {
    Text(text = "Workout")
}

@Composable
fun NoWorkoutByDate() {
    Text(text = "No Workout")
}
