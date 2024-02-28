package com.example.workoutkotlinapp.src.network.apiService.api.user

import User
import retrofit2.http.GET

interface GetUserApi {
    @GET("user/details")
    suspend fun getUser(): User
}
