package com.example.dependencyinjection_retrofit.retrofit.response.delete_response

data class DeleteResponse(
    val blocked: Boolean,
    val confirmed: Boolean,
    val createdAt: String,
    val email: String,
    val id: Int,
    val provider: String,
    val updatedAt: String,
    val username: String
)