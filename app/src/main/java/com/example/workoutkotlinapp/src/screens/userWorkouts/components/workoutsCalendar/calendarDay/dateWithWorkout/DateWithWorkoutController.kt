package com.example.workoutkotlinapp.src.screens.userWorkouts.components.workoutsCalendar.calendarDay.dateWithWorkout

import com.example.workoutkotlinapp.ActiveScreen
import com.example.workoutkotlinapp.MainIntent
import com.example.workoutkotlinapp.MainViewModel
import com.example.workoutkotlinapp.src.screens.workoutDetails.WorkoutDetailsIntent
import com.example.workoutkotlinapp.src.screens.workoutDetails.WorkoutDetailsViewModel
import com.example.workoutkotlinapp.src.types.Workout

class DateWithWorkoutController(
    private val mainViewModel: MainViewModel,
    private val workoutDetailsViewModel: WorkoutDetailsViewModel,
) {
    fun onClick(workout: Workout) {
        mainViewModel.processIntent(MainIntent.SetActiveScreen(ActiveScreen.WorkoutDetails))
        workoutDetailsViewModel.processIntent(WorkoutDetailsIntent.SetWorkout(workout))
    }
}
