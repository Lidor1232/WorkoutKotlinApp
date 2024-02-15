package com.example.workoutkotlinapp.src.screens.Register

data class RegisterState(
    val firstName: String = "",
    val lastName: String = "",
    val userName: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
)

sealed class RegisterIntent {
    data class SetFirstName(
        val firstName: String,
    ) : RegisterIntent()

    data class SetLastName(
        val lastName: String,
    ) : RegisterIntent()

    data class SetUserName(
        val userName: String,
    ) : RegisterIntent()

    data class SetPassword(
        val password: String,
    ) : RegisterIntent()

    data class SetIsLoading(val isLoading: Boolean) : RegisterIntent()

    data class SetError(val error: String?) : RegisterIntent()
}
