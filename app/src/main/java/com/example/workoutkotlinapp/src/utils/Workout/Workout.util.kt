package com.example.workoutkotlinapp.src.utils.Workout

import com.example.workoutkotlinapp.src.types.Workout

object WorkoutUtil {
    fun getWorkoutByDate(
        workouts: List<Workout>,
        date: String,
    ): Workout? {
        for (workout in workouts) {
            if (workout.date == date) {
                return workout
            }
        }
        return null
    }

    fun getWorkoutByDateOrThrow(
        workouts: List<Workout>,
        date: String,
    ): Workout {
        val workout = getWorkoutByDate(workouts, date)
        if (workout == null) {
            throw NoSuchElementException("No Workout found for date $date")
        }
        return workout
    }
}
