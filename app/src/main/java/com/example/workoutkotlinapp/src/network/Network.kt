
package com.example.workoutkotlinapp.src.network

import com.example.workoutkotlinapp.src.network.apiService.ApiService
import com.example.workoutkotlinapp.src.network.retrofitClient.retrofitClient

object ApiClient {
    fun apiService(token: String?): ApiService {
        return retrofitClient(token).create(ApiService::class.java)
    }
}
