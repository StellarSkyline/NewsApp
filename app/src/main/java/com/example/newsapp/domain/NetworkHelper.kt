/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.domain

import com.example.newsapp.data.ApiKey
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

object NetworkHelper {
    val newsInterceptor = OkHttpClient.Builder()
        .addInterceptor { chain ->
            chain.proceed(
                chain
                    .request()
                    .newBuilder()
                    .addHeader("Authorization", "Bearer ${ApiKey.newsApiKey}")
                    .build()
            )
        }
        .connectTimeout(10, TimeUnit.SECONDS) // Connect timeout
        .readTimeout(10, TimeUnit.SECONDS)    // Socket timeout
        .build()

    val photosInterceptor = OkHttpClient.Builder()
        .addInterceptor { chain ->
            chain.proceed(
                chain
                    .request()
                    .newBuilder()
                    .addHeader("Authorization", ApiKey.pexelApiKey)
                    .build()
            )
        }
        .connectTimeout(10, TimeUnit.SECONDS) // Connect timeout
        .readTimeout(10, TimeUnit.SECONDS)    // Socket timeout
        .build()
}