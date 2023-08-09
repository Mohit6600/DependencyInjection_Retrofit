package com.example.dependencyinjection_retrofit.Presentation.viewModels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dependencyinjection_retrofit.Repository.MainRepostitory
import com.example.dependencyinjection_retrofit.Rettrofit.utils.ApiState
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

    private val productPostResponse : MutableLiveData<ApiState> = MutableLiveData()
    var productPostResponseObserver : LiveData<ApiState> = productPostResponse

    suspend fun getProduct() = viewModelScope.launch {

        productPostResponse.postValue(ApiState.Loading)
        delay(1000)
        productPostResponse.postValue(ApiState.Success(mainRepostitory.sendProductList()))

    }



}