package com.example.workoutkotlinapp.src.Network.ApiService.routes.workout

import com.example.workoutkotlinapp.src.types.Workout
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

data class CreateSet(
    val weight: Int,
    val reps: Int,
)

data class CreateExercise(
    val name: String,
    val sets: List<CreateSet>,
)

data class CreateWorkoutRequest(
    val date: String,
    val exercises: List<CreateExercise>,
)

interface CreateWorkoutApi {
    @POST("workout")
    suspend fun createWorkout(
        @Body body: CreateWorkoutRequest,
    ): Call<Workout>
}
