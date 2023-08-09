package com.example.dependencyinjection_retrofit.Rettrofit.utils

import com.example.dependencyinjection_retrofit.Rettrofit.response.ProductItem
import com.example.dependencyinjection_retrofit.Rettrofit.response.ProductResponse


/*sealed class ApiState {

    object Loading: ApiState()
    class Success(val data : ProductResponse): ApiState()

}*/

sealed class ApiState {

    object Loading: ApiState()
    class Success(val data : ProductItem): ApiState()

}