package com.example.workoutkotlinapp.src.Network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

fun getLoggingHttpClient(): OkHttpClient {
    val builder = OkHttpClient.Builder()
    builder.addInterceptor(
        HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        },
    )
    return builder.build()
}
