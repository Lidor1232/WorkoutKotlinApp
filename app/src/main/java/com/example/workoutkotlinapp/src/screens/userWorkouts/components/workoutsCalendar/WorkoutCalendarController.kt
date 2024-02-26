package com.example.workoutkotlinapp.src.screens.userWorkouts.components.workoutsCalendar

import com.example.workoutkotlinapp.src.types.Workout
import com.example.workoutkotlinapp.src.utils.Date.DateUtil
import java.time.LocalDate

class WorkoutCalendarController {
    fun getWorkoutByDate(
        date: LocalDate,
        workouts: List<Workout>?,
    ): Workout? {
        if (workouts === null) {
            return null
        }
        for (workout in workouts) {
            val workoutCalendarDate = DateUtil.parseToLocalDate(workout.date)
            if (date == workoutCalendarDate) {
                return workout
            }
        }
        return null
    }
}
