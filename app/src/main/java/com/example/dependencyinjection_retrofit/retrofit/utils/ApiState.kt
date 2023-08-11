package com.example.dependencyinjection_retrofit.retrofit.utils

import android.app.Person
import com.example.dependencyinjection_retrofit.retrofit.response.PersonItem
import com.example.dependencyinjection_retrofit.retrofit.response.ProductItem


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
    class  Success(val data : PersonItem): ApiState()

    class Error(val checkData: String): ApiState()


}