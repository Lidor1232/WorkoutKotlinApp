
package com.example.workoutkotlinapp.src.Network

import com.example.workoutkotlinapp.src.Network.ApiService.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://192.168.50.94:3000/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder().client(getLoggingHttpClient())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

object ApiClient {
    val apiService: ApiService by lazy {
        RetrofitClient.retrofit.create(ApiService::class.java)
    }
}
