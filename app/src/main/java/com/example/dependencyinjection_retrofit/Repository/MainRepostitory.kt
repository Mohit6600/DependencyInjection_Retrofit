package com.example.dependencyinjection_retrofit.Repository

import com.example.dependencyinjection_retrofit.retrofit.networkApi.MyApi
import com.example.dependencyinjection_retrofit.retrofit.networkApi.response.ProductResponse
import com.example.dependencyinjection_retrofit.retrofit.networkApi.response.ProductResponseItem
import com.example.dependencyinjection_retrofit.retrofit.networkApi.response.Rating
import javax.inject.Inject


class MainRepostitory @Inject constructor(private val myApi: MyApi) {


    suspend fun getProductList():ProductResponse{

        return myApi.getData()

    }

    suspend fun sendProductList():ProductResponse{
        val rating = Rating( rate = 4.5,count = 10)
        return myApi.sendData(userProduct = ProductResponseItem(1,"Branded Clothes","best product","Mens","https://images.unsplash.com/photo-1575936123452-b67c3203c357?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8aW1hZ2V8ZW58MHx8MHx8fDA%3D&w=1000&q=80", rating = rating,500.00))
    }
}