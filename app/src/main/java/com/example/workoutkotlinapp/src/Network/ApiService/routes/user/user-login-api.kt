package com.example.workoutkotlinapp.src.Network.ApiService.routes.user

import User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

data class UserLoginRequest(
    val userName: String,
    val password: String,
)

interface UserLoginApi {
    @POST("user/login")
    fun loginUser(
        @Body body: UserLoginRequest,
    ): Call<User>
}
