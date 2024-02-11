package com.example.workoutkotlinapp.src.Network.ApiService.routes.user

import com.example.workoutkotlinapp.src.types.Workout
import retrofit2.http.GET

data class GetUserWorkoutsResponse(
    val workouts: List<Workout>,
    val userId: String,
)

interface GetUserWorkoutsApi {
    @GET("workout/user/workouts")
    suspend fun getUserWorkouts(): GetUserWorkoutsResponse
}
