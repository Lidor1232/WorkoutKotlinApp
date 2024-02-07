package com.example.workoutkotlinapp.src.Network

import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        Timber.d("NETWORK Auth Intercept")

        return chain.proceed(originalRequest)
    }
}
