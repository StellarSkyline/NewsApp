/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.domain

import com.example.newsapp.data.AllNewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MyAPI {
    @GET("all")
    suspend fun getAllNews(@Query("language") language: String, @Query("limit") limit: Int): Response<AllNewsResponse>
}
