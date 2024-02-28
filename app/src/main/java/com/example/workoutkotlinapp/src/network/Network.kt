
package com.example.workoutkotlinapp.src.network

import com.example.workoutkotlinapp.src.network.apiService.ApiService
import com.example.workoutkotlinapp.src.network.client.client

object ApiClient {
    fun apiService(token: String?): ApiService {
        return client(token).create(ApiService::class.java)
    }
}
