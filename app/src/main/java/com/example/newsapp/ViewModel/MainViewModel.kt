package com.example.newsapp.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.Data.BaseValues
import com.example.newsapp.Data.DataItem
import com.example.newsapp.Repo.MainRepo
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val repo = MainRepo()
    val allNews = MutableLiveData<List<DataItem>>()

    fun getAllNews() {
        viewModelScope.launch {
            //check for errors
            val response =  repo.getAllNews()
            if(response.isSuccessful) allNews.value = repo.getAllNews().body()!!.data!!
            else {
                Log.d("STLog", "AllNewsAPI Error: ${response.errorBody()}")
            }
        }
    }
}