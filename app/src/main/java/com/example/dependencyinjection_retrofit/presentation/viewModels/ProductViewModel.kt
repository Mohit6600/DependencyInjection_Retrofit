package com.example.dependencyinjection_retrofit.presentation.viewModels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dependencyinjection_retrofit.repository.MainRepository
import com.example.dependencyinjection_retrofit.retrofit.response.delete_response.DeleteErrorResponse
import com.example.dependencyinjection_retrofit.retrofit.response.login_response.LoginErrorResponse
import com.example.dependencyinjection_retrofit.retrofit.response.register_response.RegisterErrorResponse
import com.example.dependencyinjection_retrofit.retrofit.response.update_response.UpdateErrorResponse
import com.example.dependencyinjection_retrofit.retrofit.utils.DeleteApiState
import com.example.dependencyinjection_retrofit.retrofit.utils.LoginApiState
import com.example.dependencyinjection_retrofit.retrofit.utils.RegisterApiState
import com.example.dependencyinjection_retrofit.retrofit.utils.UpdateApiState
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

//by using @HiltViewModel and the @Inject annotation, Hilt will automatically give your ViewModel the needed tools or dependencies that require.
// You don't have to write extra code to find and give these tools to your ViewModel.
@HiltViewModel
class ProductViewModel @Inject constructor(
    @ApplicationContext private val context: Context, private val mainRepository: MainRepository
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

    //here we declare a variable that hold a live data that change time to time with our apistate

    private val userPostResponse: MutableLiveData<LoginApiState> = MutableLiveData()
    var userPostResponseObserver: LiveData<LoginApiState> = userPostResponse

    fun loginUser(username: String, password: String) {

        viewModelScope.launch {             // it is used when we create a suspend function
            userPostResponse.postValue(LoginApiState.Loading)
            try {
                val response = mainRepository.loginUser(username, password)
                userPostResponse.postValue(LoginApiState.Success(response))
            } catch (e: HttpException) {

                val response = e.response()?.errorBody()
                    ?.string()          // this line get the error response and extract them into a e.body to string
                val loginErrorResponse = Gson().fromJson(
                    response,
                    LoginErrorResponse::class.java
                )  // this line convert the jason error in kotlin object of type

                userPostResponse.postValue(LoginApiState.Error(loginErrorResponse))
            }
        }


    }

    private val registerPostResponse: MutableLiveData<RegisterApiState> = MutableLiveData()
    var registerPostResponseObserver: LiveData<RegisterApiState> = registerPostResponse

    fun registerUser(username: String, password: String, email: String) {

        viewModelScope.launch {
            registerPostResponse.postValue(RegisterApiState.Loading)
            try {
                val response = mainRepository.registerUser(email, password, username)
                registerPostResponse.postValue(RegisterApiState.Success(response))
            } catch (e: HttpException) {

                val response = e.response()?.errorBody()
                    ?.string()          // this line get the error response and extract them into a e.body to string
                val registerErrorResponse = Gson().fromJson(
                    response,
                    RegisterErrorResponse::class.java
                )  // this line convert the jason error in kotlin object of type

                registerPostResponse.postValue(RegisterApiState.Error(registerErrorResponse))
            }
        }


    }

    private val updatePostResponse: MutableLiveData<UpdateApiState> = MutableLiveData()
    val updatePostResponseObserver: LiveData<UpdateApiState> = updatePostResponse

    fun updateUser(
        updateEmail: String,
        updatePassword: String,
        updateUsername: String,
        authorizationToken: String,
        userId: Int
    ) {

        viewModelScope.launch {

            try {

                val response =
                    mainRepository.updateUser(
                        updateEmail,
                        updatePassword,
                        updateUsername,
                        authorizationToken,
                        userId
                    )
                updatePostResponse.postValue(UpdateApiState.Success(response))
            } catch (e: HttpException) {

                val response = e.response()?.errorBody()?.string()
                val updateErrorResponse = Gson().fromJson(response, UpdateErrorResponse::class.java)

                updatePostResponse.postValue(UpdateApiState.Error(updateErrorResponse))

            }


        }


    }

    private val deletePostResponse: MutableLiveData<DeleteApiState> = MutableLiveData()
     val deleteUserResponseObserver:LiveData<DeleteApiState> = deletePostResponse

    fun deleteUser( userId: Int,authorizationToken: String){

        viewModelScope.launch {


            try {
                val response= mainRepository.deleteUser(authorizationToken,userId)
                deletePostResponse.postValue(DeleteApiState.Success(response))
            }catch (e:HttpException){

                val response = e.response()?.errorBody()?.string()              //doubt
                val deleteErrorResponse = Gson().fromJson(response,DeleteErrorResponse::class.java)

                deletePostResponse.postValue(DeleteApiState.Error(deleteErrorResponse))

            }
        }

    }


}