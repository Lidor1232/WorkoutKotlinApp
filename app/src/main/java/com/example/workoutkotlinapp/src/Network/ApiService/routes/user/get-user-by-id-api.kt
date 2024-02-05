package com.example.workoutkotlinapp.src.Network.ApiService.routes.user

import User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GetUserByIdApi {
    @GET("user/details/{id}")
    fun getUserById(
        @Path("id") userId: String,
    ): Call<User>
}
