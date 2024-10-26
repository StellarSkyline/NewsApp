/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.domain

import com.example.newsapp.data.ApiKey
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor2(val token:String):Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
       return chain.proceed(
           chain
               .request()
               .newBuilder()
               .addHeader("Authorization", token)
               .build()
       )
    }
}