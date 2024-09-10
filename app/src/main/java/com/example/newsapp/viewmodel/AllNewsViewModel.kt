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
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllNewsViewModel @Inject constructor(
    private val repo: AllNewsRepo,
    private val app: Application
) : ViewModel() {
    val allNews = MutableLiveData<List<DataItem>>()

//    init{
//        Log.d("STLog", "Calling from app in VM: ${app.getString(R.string.app_name)}")
//        getAllNews()
//    }

    fun getAllNews() {
        viewModelScope.launch { allNews.value = repo.getAllNews().also { Log.d("STLog", "I'm Called") } }
    }
}