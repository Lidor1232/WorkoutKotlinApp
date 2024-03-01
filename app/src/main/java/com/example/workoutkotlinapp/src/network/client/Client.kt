package com.example.workoutkotlinapp.src.network.client

import com.example.workoutkotlinapp.src.network.networkHttpClient.getHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun client(token: String?): Retrofit {
    val baseUrl = "http://192.168.18.94:3000/"
    val retrofit: Retrofit by lazy {
        Retrofit.Builder().client(getHttpClient(token))
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    return retrofit
}
