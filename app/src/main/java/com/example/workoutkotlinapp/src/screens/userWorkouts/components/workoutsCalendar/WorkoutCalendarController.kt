package com.example.workoutkotlinapp.src.screens.userWorkouts.components.workoutsCalendar

import com.example.workoutkotlinapp.src.screens.userWorkouts.UserWorkoutsIntent
import com.example.workoutkotlinapp.src.screens.userWorkouts.UserWorkoutsViewModel
import java.time.LocalDate

class WorkoutCalendarController(
    private val userWorkoutsViewModel: UserWorkoutsViewModel,
) {
    fun handleDateSelection(selection: List<LocalDate>) {
        if (selection.isNotEmpty()) {
            val selectedDate = selection[0]
            userWorkoutsViewModel.processIntent(
                UserWorkoutsIntent.SetSelectedDate(selectedDate.toString()),
            )
        }
    }
}
