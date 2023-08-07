package com.example.dependencyinjection_retrofit.retrofit.networkApi

import com.example.dependencyinjection_retrofit.retrofit.networkApi.response.ProductResponse
import com.example.dependencyinjection_retrofit.retrofit.networkApi.response.ProductResponseItem
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MyApi {

    @GET("products")
    suspend fun getData(): ProductResponse

    @POST("products")
    suspend fun sendData(@Body userProduct: ProductResponseItem): ProductResponse

}