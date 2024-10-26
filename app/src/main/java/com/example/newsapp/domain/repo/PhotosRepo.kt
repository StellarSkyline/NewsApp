/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.domain.repo

import com.example.newsapp.data.Photo

interface PhotosRepo {
    suspend fun getPhotos(): List<Photo>
}