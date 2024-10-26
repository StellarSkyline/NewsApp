/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.domain

import com.example.newsapp.data.PhotosResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers


interface PexelAPI {
    @GET("curated")
    suspend fun getPhotos(): Response<PhotosResponse>
}