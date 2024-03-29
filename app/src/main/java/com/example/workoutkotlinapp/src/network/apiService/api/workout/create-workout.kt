package com.example.workoutkotlinapp.src.network.apiService.api.workout

import com.example.workoutkotlinapp.src.types.Exercise
import com.example.workoutkotlinapp.src.types.Workout
import retrofit2.http.Body
import retrofit2.http.POST

data class ICreateExercise(
    val name: String,
    val sets: List<Exercise.Set>,
)

data class CreateWorkoutRequest(
    val date: String,
    val exercises: List<ICreateExercise>,
)

interface CreateWorkoutApi {
    @POST("workout")
    suspend fun createWorkout(
        @Body body: CreateWorkoutRequest,
    ): Workout
}
