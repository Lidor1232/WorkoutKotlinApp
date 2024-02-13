package com.example.workoutkotlinapp.src.screens.UserWorkouts.components.WorkoutsCalendar

import com.example.workoutkotlinapp.src.types.Workout
import com.example.workoutkotlinapp.src.utils.Date.DateUtil
import timber.log.Timber
import java.time.LocalDate

class WorkoutCalendarController {
    fun isDateHasWorkout(
        date: LocalDate,
        workouts: List<Workout>?,
    ): Boolean {
        if (workouts === null) {
            return false
        }

        for (workout in workouts) {
            val workoutCalendarDate = DateUtil.parseToLocalDate(workout.date)

            if (date == workoutCalendarDate) {
                Timber.d("Equal date $date")
                return true
            }
        }

        return false
    }
}
