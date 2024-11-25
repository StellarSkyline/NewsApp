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
import com.example.newsapp.domain.repo.PhotosRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
    private val repo: PhotosRepo,
    private val app: Application,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    //Keeping this as LiveData so I have a reminder how to do it via LiveData
    val photo = MutableLiveData<Photo>()

    //Using StateFlow without SavedStateHandle
    val _allPhotos = MutableStateFlow(emptyList<Photo>())
    val allPhotos = _allPhotos.asStateFlow()

    //With SavedStateHandle
    //val allPhotos = savedStateHandle.getStateFlow("allPhotos", emptyList<Photo>())

    fun getAllPhotos() {
        viewModelScope.launch {
            _allPhotos.value = repo.getPhotos()
            //savedStateHandle["allPhotos"] = repo.getPhotos()
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("STLog", "Photos ViewModel cleared")
    }

}