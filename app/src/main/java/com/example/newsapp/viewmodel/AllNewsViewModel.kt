package com.example.newsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.AllNewsRepo
import com.example.newsapp.data.DataItem
import com.example.newsapp.data.repo.AllNewsRepoImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllNewsViewModel @Inject constructor(
    private val repo:AllNewsRepo
) : ViewModel() {
    val allNews = MutableLiveData<List<DataItem>>()

    fun getAllNews() {
        viewModelScope.launch { allNews.value = repo.getAllNews() }
    }
}