package com.example.newsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.DataItem
import com.example.newsapp.repo.MainRepo
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val repo = MainRepo()
    val allNews = MutableLiveData<List<DataItem>>()

    fun getAllNews() {
        viewModelScope.launch { allNews.value = repo.getAllNews() }
    }
}