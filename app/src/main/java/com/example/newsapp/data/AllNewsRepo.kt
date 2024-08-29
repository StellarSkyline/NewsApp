package com.example.newsapp.data

interface AllNewsRepo {
    suspend fun getAllNews(): List<DataItem>
}