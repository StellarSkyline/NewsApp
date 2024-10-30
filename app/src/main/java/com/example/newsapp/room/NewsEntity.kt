/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NewsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val url: String
)
