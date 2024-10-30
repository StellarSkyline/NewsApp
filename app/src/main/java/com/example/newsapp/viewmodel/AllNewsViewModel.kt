/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.R
import com.example.newsapp.domain.repo.AllNewsRepo
import com.example.newsapp.data.DataItem
import com.example.newsapp.data.NewsItems
import com.example.newsapp.room.NewsEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllNewsViewModel @Inject constructor(
    private val repo: AllNewsRepo,
    private val app: Application
) : ViewModel() {
    val allNews = MutableLiveData<List<DataItem>>()
    val newsURL = MutableLiveData<String>()
    val allNews2 = MutableLiveData<List<NewsItems>>()


    fun getAllNews() {
        viewModelScope.launch {
            //allNews.value = repo.getAllNews().also { Log.d("STLog", "I'm Called") }
            allNews.value = repo.getAllNews().onEach {
                repo.insertNews(title = it.title, url = it.url)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("STLog", "ViewModel cleared")
    }
}

