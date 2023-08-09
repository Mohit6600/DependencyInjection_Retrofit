package com.example.dependencyinjection_retrofit.Retrofit.response

data class ProductResponseItem(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val image: String,
    val rating: Rating,
    val price: Double
)