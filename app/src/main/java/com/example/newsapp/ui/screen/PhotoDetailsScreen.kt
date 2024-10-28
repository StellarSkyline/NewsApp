/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.constraintlayout.compose.ConstraintSet
import com.example.newsapp.viewmodel.PhotosViewModel

@Composable
fun PhotoDetailsScreen(vm: PhotosViewModel, onNavigate: (String) -> Unit = {}) {
    val photo = vm.photo.observeAsState().value
    var isSpinnerVisible: Boolean by remember { mutableStateOf(true) }

    val constrain = ConstraintSet {
        val include_spinner = createRefFor("include_spinner")
        val tv_title = createRefFor("tv_title")
        val iv_photo = createRefFor("iv_photo")
        val btn_back = createRefFor("btn_back")
        val tv_photographer = createRefFor("tv_photographer")
        val tv_website = createRefFor("tv_website")

    }

}