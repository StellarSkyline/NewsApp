/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.data.repo

import android.util.Log
import com.example.newsapp.domain.repo.AllNewsRepo
import com.example.newsapp.data.DataItem
import com.example.newsapp.domain.MyAPI
import com.example.newsapp.room.NewsDatabase
import com.example.newsapp.room.NewsEntity


class AllNewsRepoImpl(
    private val api: MyAPI,
    private val db:NewsDatabase
): AllNewsRepo {
    //Api Calls
    override suspend fun getAllNews(): List<DataItem> {
        //Api Network call
        val response = api.getAllNews("en",3)

        //Testing for Error and returning Success
        if (response.isSuccessful) return response.body()!!.data!!
        else {
            Log.d("STLog", response.errorBody().toString())
            return emptyList()
        }
    }

    //Room Calls
    override suspend fun insertNews(title: String, url: String) {
        db.dao.upsertNews(NewsEntity(title = title, url = url))
    }

    override suspend fun deleteNews(title: String, url: String) {
        db.dao.deleteNews(NewsEntity(title = title, url = url))
    }

    override suspend fun getNewsDb(): List<NewsEntity> {
        return db.dao.getNewsOrderedByTitle().value ?: emptyList()
    }

}