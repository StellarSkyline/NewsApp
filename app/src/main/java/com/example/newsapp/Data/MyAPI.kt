package com.example.newsapp.Data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MyAPI {
    //https://api.thenewsapi.com/v1/news/all?api_token=vSAFrxjAKWqHWJaJzyY4i78aRrKRT59PlJdpCwAI&language=en&limit=3
    @GET("all")
    suspend fun getAllNews(): Response<AllNewsResponse>

}
