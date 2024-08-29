/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.domain.repo

import com.example.newsapp.data.DataItem

interface AllNewsRepo {
    suspend fun getAllNews(): List<DataItem>
}