package com.example.dependencyinjection_retrofit.retrofit.networkApi.utils

import com.example.dependencyinjection_retrofit.retrofit.networkApi.response.ProductResponse


sealed class ApiState {

    object Loading: ApiState()
    class Success(val data : ProductResponse): ApiState()
}

sealed class ApiState2 {

    object Loading2: ApiState2()
    class Success2(val data2 : ProductResponse): ApiState2()
}