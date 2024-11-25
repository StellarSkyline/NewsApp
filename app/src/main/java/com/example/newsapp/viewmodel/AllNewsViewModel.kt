/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.R
import com.example.newsapp.domain.repo.AllNewsRepo
import com.example.newsapp.data.DataItem
import com.example.newsapp.data.NewsItems
import com.example.newsapp.room.NewsEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AllNewsViewModel @Inject constructor(
    private val repo: AllNewsRepo,
    private val app: Application,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    var newsURL =""
    val allNews = savedStateHandle.getStateFlow("allNews", emptyList<NewsItems>())

    fun getAllNews() {
        viewModelScope.launch(Dispatchers.IO) {
            val list:MutableList<NewsItems> = mutableListOf()

            //Add each new item to DB
            repo.getAllNews().onEach {
                repo.insertNews(title = it.title, url = it.url)
            }

            //Add each item from DB to list
            repo.getNewsDb().onEach {
                list.add(NewsItems(it.title, it.url))
            }

            //update State
            savedStateHandle["allNews"] = list
        }
    }

    fun deleteNewsTable() {
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteAllNewsTable()
            savedStateHandle["allNews"] = emptyList<NewsItems>()
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("STLog", "ViewModel cleared")
    }
}

