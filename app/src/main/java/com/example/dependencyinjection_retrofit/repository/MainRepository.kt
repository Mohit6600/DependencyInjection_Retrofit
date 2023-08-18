package com.example.dependencyinjection_retrofit.repository

import com.example.dependencyinjection_retrofit.retrofit.networkApi.MyApi
import com.example.dependencyinjection_retrofit.retrofit.response.post_response.PersonItem
import com.example.dependencyinjection_retrofit.retrofit.response.post_response.ProductResponse
import com.example.dependencyinjection_retrofit.retrofit.response.register_response.RegisterRequest
import com.example.dependencyinjection_retrofit.retrofit.response.login_response.LoginResponse
import com.example.dependencyinjection_retrofit.retrofit.response.register_response.RegisterResponse
import com.example.dependencyinjection_retrofit.retrofit.response.update_response.UpdateRequest
import com.example.dependencyinjection_retrofit.retrofit.response.update_response.UpdateResponse
import javax.inject.Inject


class MainRepository @Inject constructor(private val myApi: MyApi) {


    suspend fun getProductList(): ProductResponse {

        return myApi.getData()

    }

    /*    suspend fun addProductList(): ProductItem {

        return myApi.addProduct(

            ProductRequestItem(

                "electronic",
                "lorem ipsum set",
                "https://i.pravatar.cc",
                13.5,
                "test product"
            )
        )
    }*/

    suspend fun loginUser(identifier: String, password: String): LoginResponse {
        val personItem = PersonItem(identifier, password)
        return myApi.loginUser(personItem)
    }

    suspend fun registerUser(email: String, password: String, username: String): RegisterResponse {
        val registerItem = RegisterRequest(email, password, username)
        return myApi.registerUser(registerItem)
    }


    suspend fun updateUser(
        updateEmail: String,
        updatePassword: String,
        updateUsername: String,
        authorizationToken: String,
        userid: Int
    ): UpdateResponse {

        val updateItem = UpdateRequest(updateEmail, updatePassword, updateUsername)

        return myApi.updateUser(userid, updateItem, "Bearer " + authorizationToken)     // always give a space after writing bearer for token


    }


}