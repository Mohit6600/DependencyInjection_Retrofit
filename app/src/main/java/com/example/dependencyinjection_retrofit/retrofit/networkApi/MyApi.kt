package com.example.dependencyinjection_retrofit.retrofit.networkApi

import com.example.dependencyinjection_retrofit.retrofit.response.delete_response.DeleteResponse
import com.example.dependencyinjection_retrofit.retrofit.response.post_response.PersonItem
import com.example.dependencyinjection_retrofit.retrofit.response.post_response.ProductItem
import com.example.dependencyinjection_retrofit.retrofit.response.post_response.ProductRequestItem
import com.example.dependencyinjection_retrofit.retrofit.response.post_response.ProductResponse
import com.example.dependencyinjection_retrofit.retrofit.response.register_response.RegisterRequest
import com.example.dependencyinjection_retrofit.retrofit.response.login_response.LoginResponse
import com.example.dependencyinjection_retrofit.retrofit.response.register_response.RegisterResponse
import com.example.dependencyinjection_retrofit.retrofit.response.update_response.UpdateRequest
import com.example.dependencyinjection_retrofit.retrofit.response.update_response.UpdateResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface MyApi {

    @GET("products")
    suspend fun getData(): ProductResponse

   /* @POST("products")
    suspend fun addProduct(@Body product: ProductRequestItem): ProductItem*/

    @POST("api/auth/local")
    suspend fun loginUser(@Body User: PersonItem): LoginResponse

    @POST("api/auth/local/register")
    suspend fun registerUser(@Body Register: RegisterRequest): RegisterResponse

    @PUT("api/users/{id}")
    suspend fun updateUser(
        @Path("id") id: Int,
        @Body Update: UpdateRequest, @Header("Authorization") basicToken: String
    ): UpdateResponse

    @DELETE("api/users/{id}")
    suspend fun deleteUser(
        @Path("id") id: Int,
        @Header("Authorization") token: String
    ): DeleteResponse

}