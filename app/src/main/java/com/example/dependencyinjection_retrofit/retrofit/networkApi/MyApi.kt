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

  // this api is used to register a user
    @POST("api/auth/local/register")
    suspend fun registerUser(@Body Register: RegisterRequest): RegisterResponse

    // this api is used to login a user account
    @POST("api/auth/local")
    suspend fun loginUser(@Body User: PersonItem): LoginResponse

    //this api is used to update the detail of the user for that we need a authorization token and user id we have to provide without those it will not work also
    //id will be defined as "Path"  and "Header" is used for the toke we received whenever we login the id
    @PUT("api/users/{id}")
    suspend fun updateUser(
        @Path("id") id: Int,
        @Body Update: UpdateRequest, @Header("Authorization") basicToken: String
    ): UpdateResponse

    // this api is used for delete the user data from the Url or site
    @DELETE("api/users/{id}")
    suspend fun deleteUser(
        @Path("id") id: Int,
        @Header("Authorization") token: String
    ): DeleteResponse

}