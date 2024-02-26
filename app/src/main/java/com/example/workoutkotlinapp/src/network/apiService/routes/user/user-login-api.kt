package com.example.workoutkotlinapp.src.network.apiService.routes.user

import User
import retrofit2.http.Body
import retrofit2.http.POST

data class UserLoginRequest(
    val userName: String,
    val password: String,
)

data class UserLoginResponse(val user: User, val token: String)

interface UserLoginApi {
    @POST("user/login")
    suspend fun loginUser(
        @Body body: UserLoginRequest,
    ): UserLoginResponse
}
