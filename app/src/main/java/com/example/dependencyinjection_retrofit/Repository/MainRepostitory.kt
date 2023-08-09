package com.example.dependencyinjection_retrofit.Repository

import com.example.dependencyinjection_retrofit.Rettrofit.response.ProductItem
import com.example.dependencyinjection_retrofit.Rettrofit.response.ProductRequestItem
import com.example.dependencyinjection_retrofit.Rettrofit.networkApi.MyApi
import com.example.dependencyinjection_retrofit.Rettrofit.response.ProductResponse
import javax.inject.Inject


class MainRepostitory @Inject constructor(private val myApi: MyApi) {


    suspend fun getProductList(): ProductResponse {

        return myApi.getData()

    }

    suspend fun sendProductList(): ProductItem {

        return myApi.AddProduct(

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