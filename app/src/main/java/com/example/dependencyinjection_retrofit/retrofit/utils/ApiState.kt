package com.example.dependencyinjection_retrofit.retrofit.utils

import com.example.dependencyinjection_retrofit.retrofit.response.PersonItem
import com.example.dependencyinjection_retrofit.retrofit.response.login_response.LoginResponse
import com.example.dependencyinjection_retrofit.retrofit.response.login_response.LoginErrorResponse


/*sealed class ApiState {

    object Loading: ApiState()
    class Success(val data : ProductResponse): ApiState()

}*/

// this is used for product api

/*sealed class ApiState {

    object Loading: ApiState()
    class Success(val data : ProductItem): ApiState()

}*/

// this is used for user api

sealed class ApiState{

    object Loading: ApiState()
    class  Success(val data: LoginResponse): ApiState()

    class Error(val data: LoginErrorResponse): ApiState()

}