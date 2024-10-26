/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.domain

import com.example.newsapp.data.ApiKey
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

object NetworkHelper {
    val newsInterceptor = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor(ApiKey.newsApiKey))
        .connectTimeout(10, TimeUnit.SECONDS) // Connect timeout
        .readTimeout(10, TimeUnit.SECONDS)    // Socket timeout
        .build()

    val photosInterceptor = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor2(ApiKey.pexelApiKey))
        .connectTimeout(10, TimeUnit.SECONDS) // Connect timeout
        .readTimeout(10, TimeUnit.SECONDS)    // Socket timeout
        .build()
}