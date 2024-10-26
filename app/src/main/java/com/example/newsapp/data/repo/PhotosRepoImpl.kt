/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.data.repo

import android.util.Log
import com.example.newsapp.data.ApiKey
import com.example.newsapp.data.Photo
import com.example.newsapp.domain.PexelAPI
import com.example.newsapp.domain.repo.PhotosRepo

class PhotosRepoImpl(
    private val api: PexelAPI
): PhotosRepo {
    override suspend fun getPhotos(): List<Photo> {
        val response = api.getPhotos()

        if(response.isSuccessful) return response.body()!!.photos
        else {
            Log.d("STLog", "Error: ${response.errorBody()}")
            return emptyList()
        }
    }
}