package com.example.workoutkotlinapp.src.Network.RetrofitClient

import com.example.workoutkotlinapp.src.Network.NetworkHttpClient.getHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun retrofitClient(token: String?): Retrofit {
    val baseUrl = "http://192.168.60.94:3000/"
    val retrofit: Retrofit by lazy {
        Retrofit.Builder().client(getHttpClient(token))
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    return retrofit
}
