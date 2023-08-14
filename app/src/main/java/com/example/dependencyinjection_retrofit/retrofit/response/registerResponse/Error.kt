package com.example.dependencyinjection_retrofit.retrofit.response.registerResponse

data class Error(
    val details: Details,
    val message: String,
    val name: String,
    val status: Int
)