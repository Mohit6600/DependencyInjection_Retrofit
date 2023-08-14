package com.example.dependencyinjection_retrofit.retrofit.utils

import com.example.dependencyinjection_retrofit.retrofit.response.login_response.LoginResponse
import com.example.dependencyinjection_retrofit.retrofit.response.login_response.LoginErrorResponse
import com.example.dependencyinjection_retrofit.retrofit.response.register_response.RegisterErrorResponse
import com.example.dependencyinjection_retrofit.retrofit.response.register_response.RegisterResponse


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

sealed class LoginApiState{

    object Loading: LoginApiState()
    class  Success(val data: LoginResponse): LoginApiState()

    class Error(val data: LoginErrorResponse): LoginApiState()

}

sealed class RegisterApiState{

    object Loading: RegisterApiState()
    class  Success(val data: RegisterResponse): RegisterApiState()

    class Error(val data: RegisterErrorResponse): RegisterApiState()

}