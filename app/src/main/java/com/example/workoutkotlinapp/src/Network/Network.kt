
package com.example.workoutkotlinapp.src.Network

import com.example.workoutkotlinapp.src.Network.ApiService.ApiService
import com.example.workoutkotlinapp.src.Network.RetrofitClient.retrofitClient

object ApiClient {
    fun apiService(token: String?): ApiService {
        return retrofitClient(token).create(ApiService::class.java)
    }
}
