package com.example.newsapp.data.repo

import android.app.Application
import android.util.Log
import com.example.newsapp.data.AllNewsRepo
import com.example.newsapp.data.AllNewsResponse
import com.example.newsapp.data.DataItem
import com.example.newsapp.data.MyAPI
import com.example.newsapp.data.NetworkHelper
import retrofit2.Response


class AllNewsRepoImpl(
    private val api:MyAPI,
):AllNewsRepo {
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
}