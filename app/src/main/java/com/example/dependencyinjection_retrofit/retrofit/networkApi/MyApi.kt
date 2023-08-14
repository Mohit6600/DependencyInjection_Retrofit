package com.example.dependencyinjection_retrofit.retrofit.networkApi

import com.example.dependencyinjection_retrofit.retrofit.response.PersonItem
import com.example.dependencyinjection_retrofit.retrofit.response.ProductItem
import com.example.dependencyinjection_retrofit.retrofit.response.ProductRequestItem
import com.example.dependencyinjection_retrofit.retrofit.response.ProductResponse
import com.example.dependencyinjection_retrofit.retrofit.response.register_response.RegisterRequest
import com.example.dependencyinjection_retrofit.retrofit.response.login_response.LoginResponse
import com.example.dependencyinjection_retrofit.retrofit.response.register_response.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface MyApi {

    @GET("products")
    suspend fun getData(): ProductResponse

    @POST("products")
    suspend fun addProduct(@Body product: ProductRequestItem): ProductItem

    @POST("api/auth/local")
    suspend fun loginUser(@Body User:PersonItem):LoginResponse

    @POST("api/auth/local/register")
    suspend fun registerUser(@Body Register : RegisterRequest):RegisterResponse

    @PUT("api/auth/local")
    suspend fun changeData(@Body UserData : PersonItem):LoginResponse


}