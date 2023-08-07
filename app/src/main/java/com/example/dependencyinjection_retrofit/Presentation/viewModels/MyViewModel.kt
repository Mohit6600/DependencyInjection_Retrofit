package com.example.dependencyinjection_retrofit.Presentation.viewModels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dependencyinjection_retrofit.Repository.MainRepostitory
import com.example.dependencyinjection_retrofit.retrofit.networkApi.utils.ApiState
import com.example.dependencyinjection_retrofit.retrofit.networkApi.utils.ApiState2
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    @ApplicationContext private val context: Context, private val mainRepostitory: MainRepostitory
):ViewModel(){



/*    private val productPostResponse : MutableLiveData<ApiState> = MutableLiveData()
    var productPostResponseObserver : LiveData<ApiState> = productPostResponse

    suspend fun getProduct() = viewModelScope.launch {

        productPostResponse.postValue(ApiState.Loading)
        delay(1000)
        productPostResponse.postValue(ApiState.Success(mainRepostitory.getProductList()))

    }*/

    private val productPostResponse2 : MutableLiveData<ApiState2> = MutableLiveData()
    var productPostResponseObserver2 : LiveData<ApiState2> = productPostResponse2

    suspend fun getProduct2() = viewModelScope.launch {

        productPostResponse2.postValue(ApiState2.Loading2)
        delay(1000)
        productPostResponse2.postValue(ApiState2.Success2(mainRepostitory.sendProductList()))

    }



}