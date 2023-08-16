package com.example.dependencyinjection_retrofit.retrofit.response.update_response

data class Error(
    val details: Details,
    val message: String,
    val name: String,
    val status: Int
)