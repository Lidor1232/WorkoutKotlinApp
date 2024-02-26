package com.example.workoutkotlinapp.src.Network.ApiService.routes.user

import User
import retrofit2.http.GET
import retrofit2.http.Path

interface GetUserApi {
    @GET("user/{userId}/details")
    suspend fun getUser(
        @Path("userId") userId: String,
    ): User
}
