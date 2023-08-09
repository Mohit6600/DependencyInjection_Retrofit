package com.example.dependencyinjection_retrofit.Retrofit.utils

import com.example.dependencyinjection_retrofit.Retrofit.response.ProductItem


/*sealed class ApiState {

    object Loading: ApiState()
    class Success(val data : ProductResponse): ApiState()

}*/

sealed class ApiState {

    object Loading: ApiState()
    class Success(val data : ProductItem): ApiState()

}