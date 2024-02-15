package com.example.workoutkotlinapp.src.Network.NetworkHttpClient

import com.example.workoutkotlinapp.src.Network.NetworkHttpClient.AuthInterceptor.AuthInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

fun getHttpClient(token: String?): OkHttpClient {
    val client = OkHttpClient.Builder()

    addLoggingInterceptorToHttpClientBuilder(client)
    addAuthInterceptorToHttpClientBuilder(client, token)

    return client.build()
}

fun addLoggingInterceptorToHttpClientBuilder(client: OkHttpClient.Builder) {
    client.addInterceptor(
        HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        },
    )
}

fun addAuthInterceptorToHttpClientBuilder(
    client: OkHttpClient.Builder,
    token: String?,
) {
    client.addInterceptor(AuthInterceptor(token))
}
