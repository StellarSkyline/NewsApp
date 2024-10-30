/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.domain.repo

import com.example.newsapp.data.DataItem
import com.example.newsapp.room.NewsEntity

interface AllNewsRepo {
    suspend fun getAllNews(): List<DataItem>
    suspend fun insertNews(title:String, url:String)
    suspend fun deleteNews(title:String, url:String)
    suspend fun getNewsDb(): List<NewsEntity>

}