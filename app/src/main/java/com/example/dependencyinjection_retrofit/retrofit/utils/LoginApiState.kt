package com.example.dependencyinjection_retrofit.retrofit.utils

import com.example.dependencyinjection_retrofit.retrofit.response.delete_response.DeleteErrorResponse
import com.example.dependencyinjection_retrofit.retrofit.response.delete_response.DeleteResponse
import com.example.dependencyinjection_retrofit.retrofit.response.login_response.LoginResponse
import com.example.dependencyinjection_retrofit.retrofit.response.login_response.LoginErrorResponse
import com.example.dependencyinjection_retrofit.retrofit.response.register_response.RegisterErrorResponse
import com.example.dependencyinjection_retrofit.retrofit.response.register_response.RegisterResponse
import com.example.dependencyinjection_retrofit.retrofit.response.update_response.UpdateErrorResponse
import com.example.dependencyinjection_retrofit.retrofit.response.update_response.UpdateRequest
import com.example.dependencyinjection_retrofit.retrofit.response.update_response.UpdateResponse


/*sealed class ApiState {

    object Loading: ApiState()
    class Success(val data : ProductResponse): ApiState()

}*/

// this is used for product api

/*sealed class ApiState {

    object Loading: ApiState()
    class Success(val data : ProductItem): ApiState()

}*/


// the sealed class here is create for seeing a different stages for api working it helps in clean coding

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

sealed class UpdateApiState{

    object Loading : UpdateApiState()

    class Success(val data: UpdateResponse): UpdateApiState()

    class Error( val data: UpdateErrorResponse): UpdateApiState()


}

sealed class DeleteApiState{

    object Loading:DeleteApiState()

    class Success(val data:DeleteResponse): DeleteApiState()

    class Error(val data:DeleteErrorResponse):DeleteApiState()

}