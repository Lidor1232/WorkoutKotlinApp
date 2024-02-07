package com.example.workoutkotlinapp.src.Network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

fun getHttpClient(): OkHttpClient {
    val client = OkHttpClient.Builder()

    addLoggingInterceptorToHttpClientBuilder(client)
    addAuthInterceptorToHttpClientBuilder(client)

    return client.build()
}

fun addLoggingInterceptorToHttpClientBuilder(client: OkHttpClient.Builder) {
    client.addInterceptor(
        HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        },
    )
}

fun addAuthInterceptorToHttpClientBuilder(client: OkHttpClient.Builder) {
    client.addInterceptor(AuthInterceptor())
}
