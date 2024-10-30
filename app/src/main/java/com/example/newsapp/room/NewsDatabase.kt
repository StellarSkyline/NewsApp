/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [NewsEntity::class],
    version = 1
)
abstract class NewsDatabase: RoomDatabase() {
    abstract val dao: NewsDao
}