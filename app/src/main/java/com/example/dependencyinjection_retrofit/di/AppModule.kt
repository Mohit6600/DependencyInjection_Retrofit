package com.example.dependencyinjection_retrofit.di

import com.example.dependencyinjection_retrofit.retrofit.networkApi.MyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideApiService(): MyApi = Retrofit.Builder().run {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .connectTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS)
            .writeTimeout(100, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .retryOnConnectionFailure(true)
            .build()
        baseUrl(Constant.BASE_URL_JSON).client(
            OkHttpClient.Builder().addInterceptor(loggingInterceptor)
                .build()
        ).addConverterFactory(GsonConverterFactory.create()).build()
    }.create(MyApi::class.java)


}

/*object Const{

  const val BASE_URL="https://fakestoreapi.com/"

}*/

object Constant {

    const val BASE_URL_JSON = "https://strapi-crud-api.onrender.com/"

}