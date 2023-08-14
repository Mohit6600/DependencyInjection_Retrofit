package com.example.dependencyinjection_retrofit.retrofit.response.register_response

data class Error(
    val details: Details,
    val message: String,
    val name: String,
    val status: Int
)