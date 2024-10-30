/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun upsertNews(data:NewsEntity)

    @Delete
    suspend fun deleteNews(data:NewsEntity)

    @Query("SELECT * FROM newsentity ORDER BY title ASC")
    fun getNewsOrderedByTitle(): LiveData<List<NewsEntity>>
}