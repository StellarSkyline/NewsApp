package com.example.newsapp.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MyAPI {
    @GET("all")
    suspend fun getAllNews(@Query("language") language: String, @Query("limit") limit: Int): Response<AllNewsResponse>
}
