/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(data:NewsEntity)

    @Delete
    suspend fun deleteNews(data:NewsEntity)

    @Query("DELETE FROM newsentity")
    fun deleteAllNewsTable()

    @Query("SELECT * FROM newsentity")
    fun getNewsOrderedByTitle(): List<NewsEntity>
}