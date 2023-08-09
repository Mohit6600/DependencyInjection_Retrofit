package com.example.dependencyinjection_retrofit.Retrofit.response

data class ProductRequestItem(
    val category: String,
    val description: String,
    val image: String,
    val price: Double,
    val title: String
)