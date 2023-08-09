package com.example.dependencyinjection_retrofit.Rettrofit.networkApi

import com.example.dependencyinjection_retrofit.Rettrofit.response.ProductItem
import com.example.dependencyinjection_retrofit.Rettrofit.response.ProductRequestItem
import com.example.dependencyinjection_retrofit.Rettrofit.response.ProductResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MyApi {

    @GET("products")
    suspend fun getData(): ProductResponse

    @POST("products")
    suspend fun AddProduct(@Body product: ProductRequestItem): ProductItem

}