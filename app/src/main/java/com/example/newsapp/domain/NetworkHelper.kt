/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.domain

import com.example.newsapp.data.ApiKey
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

object NetworkHelper {
    val interceptor = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor(ApiKey.token))
        .connectTimeout(10, TimeUnit.SECONDS) // Connect timeout
        .readTimeout(10, TimeUnit.SECONDS)    // Socket timeout
        .build()
}