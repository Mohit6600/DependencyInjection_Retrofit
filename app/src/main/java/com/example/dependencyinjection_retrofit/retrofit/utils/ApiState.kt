package com.example.dependencyinjection_retrofit.retrofit.utils

import com.example.dependencyinjection_retrofit.retrofit.response.ProductItem


/*sealed class ApiState {

    object Loading: ApiState()
    class Success(val data : ProductResponse): ApiState()

}*/

sealed class ApiState {

    object Loading: ApiState()
    class Success(val data : ProductItem): ApiState()

}