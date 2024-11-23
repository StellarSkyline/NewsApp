/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.Photo
import com.example.newsapp.domain.repo.AllNewsRepo
import com.example.newsapp.domain.repo.PhotosRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
    private val repo: PhotosRepo,
    private val app: Application
) : ViewModel() {

    val allPhotos = MutableLiveData<List<Photo>>()
    val photo = MutableLiveData<Photo>()

    fun getAllPhotos() {
        viewModelScope.launch(Dispatchers.IO) {
            allPhotos.value = repo.getPhotos()
        }
    }


    override fun onCleared() {
        super.onCleared()
        Log.d("STLog", "Photos ViewModel cleared")
    }

}