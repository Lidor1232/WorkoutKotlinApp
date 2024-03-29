package com.example.workoutkotlinapp.src.network.apiService.api.exercise

import com.example.workoutkotlinapp.src.types.Exercise
import retrofit2.http.GET
import retrofit2.http.Path

data class GetWorkoutExercisesResponse(
    val workoutId: String,
    val exercises: List<Exercise>,
)

interface GetWorkoutExercises {
    @GET("exercise/workout/{workoutId}/exercises")
    suspend fun getWorkoutExercises(
        @Path("workoutId") workoutId: String,
    ): GetWorkoutExercisesResponse
}
