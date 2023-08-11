package com.example.dependencyinjection_retrofit.di

import com.example.dependencyinjection_retrofit.retrofit.networkApi.MyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideApiService(): MyApi = Retrofit.Builder().run {

        baseUrl(Constant.BASE_URL_JSON).addConverterFactory(GsonConverterFactory.create()).build()
    }.create(MyApi::class.java)


}

/*object Const{

  const val BASE_URL="https://fakestoreapi.com/"

}*/

object Constant{

    const val BASE_URL_JSON="https://strapi-crud-api.onrender.com/"

}