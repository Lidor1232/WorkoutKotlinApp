package com.example.workoutkotlinapp.src.screens.UserWorkouts.components.WorkoutsCalendar.DateWithoutWorkout

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.boguszpawlowski.composecalendar.day.DayState
import io.github.boguszpawlowski.composecalendar.selection.DynamicSelectionState

@Composable
fun DateWithoutWorkout(dayState: DayState<DynamicSelectionState>) {
    Text(dayState.date.dayOfMonth.toString(), modifier = Modifier.padding(16.dp))
}
