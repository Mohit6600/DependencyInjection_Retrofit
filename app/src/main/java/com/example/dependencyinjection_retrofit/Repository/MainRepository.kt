package com.example.dependencyinjection_retrofit.Repository

import com.example.dependencyinjection_retrofit.Retrofit.response.ProductItem
import com.example.dependencyinjection_retrofit.Retrofit.response.ProductRequestItem
import com.example.dependencyinjection_retrofit.Retrofit.networkApi.MyApi
import com.example.dependencyinjection_retrofit.Retrofit.response.ProductResponse
import javax.inject.Inject


class MainRepository @Inject constructor(private val myApi: MyApi) {


    suspend fun getProductList(): ProductResponse {

        return myApi.getData()

    }

    suspend fun addProductList(): ProductItem {

        return myApi.addProduct(

            ProductRequestItem(

                "electronic",
                "lorem ipsum set",
                "https://i.pravatar.cc",
                13.5,
                "test product"
            )
        )
    }
}