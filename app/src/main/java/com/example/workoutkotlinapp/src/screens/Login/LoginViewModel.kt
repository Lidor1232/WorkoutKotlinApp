package com.example.workoutkotlinapp.src.screens.Login

import User
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.workoutkotlinapp.src.Network.ApiClient
import com.example.workoutkotlinapp.src.Network.ApiService.routes.TestResponse
import com.example.workoutkotlinapp.src.Network.ApiService.routes.user.UserLoginRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class LoginViewModel : ViewModel() {
    private val _state = MutableLiveData(LoginState())
    val state: LiveData<LoginState> get() = _state

    fun processIntent(intent: LoginIntent) {
        when (intent) {
            is LoginIntent.SetUserName -> {
                _state.value = _state.value?.copy(userName = intent.userName)
            }

            is LoginIntent.SetPassword -> {
                _state.value = _state.value?.copy(password = intent.password)
            }
        }
    }

    fun userLogin() {
        val body = UserLoginRequest("dummyUserName", "dummyPassword")
        val call = ApiClient.apiService.loginUser(body = body)

        call.enqueue(
            object : Callback<User> {
                override fun onResponse(
                    call: Call<User>,
                    response: Response<User>,
                ) {
                    if (response.isSuccessful) {
                        Timber.d("LOGIN SuccessFull")
                    } else {
                        Timber.d(response.toString())
                        Timber.d("LOGIN Fail")
                    }
                }

                override fun onFailure(
                    call: Call<User>,
                    t: Throwable,
                ) {
                    Timber.d("Dummy Failed")
                    Timber.d("Dummy Failed $t")
                }
            },
        )
    }

    fun test() {
        val call = ApiClient.apiService.test()

        call.enqueue(
            object : Callback<TestResponse> {
                override fun onResponse(
                    call: Call<TestResponse>,
                    response: Response<TestResponse>,
                ) {
                    if (response.isSuccessful) {
                        Timber.d("LOGIN SuccessFull")
                        Timber.d("LOGIN Response: ${response.body()?.statusCode}")
                        Timber.d("LOGIN Response: ${response.body()?.message}")
                    } else {
                        Timber.d(response.toString())
                        Timber.d("LOGIN Fail")
                    }
                }

                override fun onFailure(
                    call: Call<TestResponse>,
                    t: Throwable,
                ) {
                    Timber.d("Dummy Failed")
                    Timber.d("Dummy Failed $t")
                }
            },
        )
    }
}
