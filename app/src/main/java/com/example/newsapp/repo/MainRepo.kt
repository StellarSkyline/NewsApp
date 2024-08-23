package com.example.newsapp.repo

import android.util.Log
import com.example.newsapp.data.ApiKey
import com.example.newsapp.data.DataItem
import com.example.newsapp.data.NetworkHelper


class MainRepo {
    //Api Calls
    suspend fun getAllNews(): List<DataItem> {
        //Api Network call
        val response = NetworkHelper.api.getAllNews("en",3)

        //Testing for Error and returning Success
        if (response.isSuccessful) return response.body()!!.data!!
        else {
            Log.d("STLog", response.errorBody().toString())
            return emptyList()
        }
    }
}