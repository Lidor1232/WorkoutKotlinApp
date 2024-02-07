
package com.example.workoutkotlinapp.src.Network

import com.example.workoutkotlinapp.src.Network.ApiService.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun retrofitClient(): Retrofit {
    val baseUrl = "http://192.168.50.94:3000/"
    val retrofit: Retrofit by lazy {
        Retrofit.Builder().client(getHttpClient())
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    return retrofit
}

object ApiClient {
    val apiService: ApiService by lazy {
        retrofitClient().create(ApiService::class.java)
    }
}
