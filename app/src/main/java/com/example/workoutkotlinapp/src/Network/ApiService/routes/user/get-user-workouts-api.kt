package com.example.workoutkotlinapp.src.Network.ApiService.routes.user

import com.example.workoutkotlinapp.src.types.Workout
import retrofit2.Call
import retrofit2.http.GET

data class GetUserWorkoutsResponse(
    val workouts: List<Workout>,
    val userId: String,
)

interface GetUserWorkoutsApi {
    @GET("user/workouts")
    suspend fun getUserWorkouts(): Call<GetUserWorkoutsResponse>
}
