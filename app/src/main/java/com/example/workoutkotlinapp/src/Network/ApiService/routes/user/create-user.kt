package com.example.workoutkotlinapp.src.Network.ApiService.routes.user

import User
import retrofit2.http.Body
import retrofit2.http.POST

data class CreateUserRequest(
    val firstName: String,
    val lastName: String,
    val userName: String,
    val password: String,
)

data class CreateUserResponse(
    val user: User,
    val token: String,
)

interface CreateUserApi {
    @POST("user/create")
    suspend fun createUser(
        @Body body: CreateUserRequest,
    ): CreateUserResponse
}
