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
import com.example.newsapp.data.Photo
import com.example.newsapp.domain.repo.AllNewsRepo
import com.example.newsapp.domain.repo.PhotosRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
    private val repo: PhotosRepo,
    private val app: Application,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var photo = Photo()
    val allPhotos = savedStateHandle.getStateFlow("allPhotos", emptyList<Photo>())

    fun getAllPhotos() {
        viewModelScope.launch {
            savedStateHandle["allPhotos"] = repo.getPhotos()
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("STLog", "Photos ViewModel cleared")
    }

}