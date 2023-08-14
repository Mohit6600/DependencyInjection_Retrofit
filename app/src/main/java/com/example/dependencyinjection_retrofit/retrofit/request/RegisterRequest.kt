package com.example.dependencyinjection_retrofit.retrofit.request

data class RegisterRequest(
    val email: String,
    val password: String,
    val username: String
)