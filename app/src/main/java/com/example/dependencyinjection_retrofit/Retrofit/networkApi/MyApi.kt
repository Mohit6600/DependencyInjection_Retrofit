package com.example.dependencyinjection_retrofit.Retrofit.networkApi

import com.example.dependencyinjection_retrofit.Retrofit.response.ProductItem
import com.example.dependencyinjection_retrofit.Retrofit.response.ProductRequestItem
import com.example.dependencyinjection_retrofit.Retrofit.response.ProductResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MyApi {

    @GET("products")
    suspend fun getData(): ProductResponse

    @POST("products")
    suspend fun addProduct(@Body product: ProductRequestItem): ProductItem

}