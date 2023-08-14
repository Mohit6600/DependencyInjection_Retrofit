package com.example.dependencyinjection_retrofit.retrofit.utils

import android.app.Person
import com.example.dependencyinjection_retrofit.retrofit.response.PersonItem
import com.example.dependencyinjection_retrofit.retrofit.response.ProductItem
import com.example.dependencyinjection_retrofit.retrofit.response.loginResponse.LoginErrorResponse
import com.example.dependencyinjection_retrofit.retrofit.response.loginResponse.LoginResponse
import com.example.dependencyinjection_retrofit.retrofit.response.registerResponse.RegisterErrorResponse
import com.example.dependencyinjection_retrofit.retrofit.response.registerResponse.RegisterResponse


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

sealed class ApiState {

    object Loading : ApiState()
    class Success(val data: LoginResponse) : ApiState()

    class Error(val data: LoginErrorResponse) : ApiState()


}

sealed class RegisterApiState {

    object Loading : RegisterApiState()
    class Success(val data: RegisterResponse) : RegisterApiState()

    class Error(val data: RegisterErrorResponse) : RegisterApiState()


}