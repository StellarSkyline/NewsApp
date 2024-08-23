package com.example.newsapp.data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkHelper {
    private val interceptor = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor(ApiKey.token))
        .connectTimeout(10, TimeUnit.SECONDS) // Connect timeout
        .readTimeout(10, TimeUnit.SECONDS)    // Socket timeout
        .build()

    val api = Retrofit.Builder()
        .baseUrl(BaseValues.baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(interceptor)
        .build()
        .create(MyAPI::class.java)
}