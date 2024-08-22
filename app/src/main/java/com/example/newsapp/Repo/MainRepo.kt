package com.example.newsapp.Repo

import com.example.newsapp.Data.ApiKey
import com.example.newsapp.Data.AuthInterceptor
import com.example.newsapp.Data.BaseValues
import com.example.newsapp.Data.MyAPI
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainRepo {

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor(ApiKey.apiToken))
        .build()

    private val api = Retrofit.Builder()
        .baseUrl(BaseValues.baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(okHttpClient)
        .build()
        .create(MyAPI::class.java)

    //Api Calls
    suspend fun getAllNews() = api.getAllNews()

}