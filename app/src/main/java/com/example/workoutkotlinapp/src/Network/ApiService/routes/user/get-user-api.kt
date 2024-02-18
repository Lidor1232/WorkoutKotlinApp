package com.example.workoutkotlinapp.src.Network.ApiService.routes.user

import User
import retrofit2.http.GET

interface GetUserApi {
    @GET("user/details")
    suspend fun getUser(): User
}
