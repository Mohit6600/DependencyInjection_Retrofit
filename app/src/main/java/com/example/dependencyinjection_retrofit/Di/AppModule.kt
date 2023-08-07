package com.example.dependencyinjection_retrofit.Di

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

        baseUrl("https://fakestoreapi.com/").addConverterFactory(GsonConverterFactory.create()).build()
    }.create(MyApi::class.java)


}