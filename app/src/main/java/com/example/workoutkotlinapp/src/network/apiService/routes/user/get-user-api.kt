package com.example.workoutkotlinapp.src.network.apiService.routes.user

import User
import retrofit2.http.GET

interface GetUserApi {
    @GET("user/details")
    suspend fun getUser(): User
}
