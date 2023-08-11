package com.example.dependencyinjection_retrofit.presentation.viewModels

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dependencyinjection_retrofit.repository.MainRepository
import com.example.dependencyinjection_retrofit.retrofit.response.loginResponse.LoginErrorResponse
import com.example.dependencyinjection_retrofit.retrofit.utils.ApiState
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    @ApplicationContext private val context: Context, private val mainRepostitory: MainRepository
) : ViewModel() {


    /*    private val productPostResponse : MutableLiveData<ApiState> = MutableLiveData()
    var productPostResponseObserver : LiveData<ApiState> = productPostResponse

    suspend fun getProduct() = viewModelScope.launch {

        productPostResponse.postValue(ApiState.Loading)
        delay(1000)
        productPostResponse.postValue(ApiState.Success(mainRepostitory.getProductList()))

    }*/

    /*   private val productPostResponse : MutableLiveData<ApiState> = MutableLiveData()
    var productPostResponseObserver : LiveData<ApiState> = productPostResponse

    suspend fun addProduct() = viewModelScope.launch {

        productPostResponse.postValue(ApiState.Loading)
        delay(1000)
        productPostResponse.postValue(ApiState.Success(mainRepostitory.addProductList()))

    }*/

    private val userPostResponse: MutableLiveData<ApiState> = MutableLiveData()
    var userPostResponseObserver: LiveData<ApiState> = userPostResponse

    fun loginUser(username: String, password: String) {
        viewModelScope.launch {
            userPostResponse.postValue(ApiState.Loading)
            try {
                val response = mainRepostitory.loginUser(username, password)
                userPostResponse.postValue(ApiState.Success(response))
            } catch (e: HttpException) {
                val response = e.response()?.errorBody()?.string()
                val loginErrorResponse = Gson().fromJson(
                    response,
                    LoginErrorResponse::class.java
                )
                userPostResponse.postValue(ApiState.Error(loginErrorResponse))

            }
            //userPostResponse.postValue(ApiState.Error(errorBody))
        }
    }

}
}