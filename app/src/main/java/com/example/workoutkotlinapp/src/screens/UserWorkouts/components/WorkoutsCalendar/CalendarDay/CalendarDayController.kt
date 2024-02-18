package com.example.workoutkotlinapp.src.screens.UserWorkouts.components.WorkoutsCalendar.CalendarDay

import com.example.workoutkotlinapp.src.types.Workout
import com.example.workoutkotlinapp.src.utils.Date.DateUtil
import java.time.LocalDate

class CalendarDayController {
    fun getWorkoutByDate(
        date: LocalDate,
        workouts: List<Workout>,
    ): Workout? {
        for (workout in workouts) {
            val workoutCalendarDate = DateUtil.parseToLocalDate(workout.date)
            if (date == workoutCalendarDate) {
                return workout
            }
        }
        return null
    }
}
