/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.newsapp.ui.components.CustomButton
import com.example.newsapp.ui.navigation.Screen
import com.example.newsapp.viewmodel.PhotosViewModel

@Composable
fun PhotosScreen(navController: NavController) {

    val vm = hiltViewModel<PhotosViewModel>()

    LaunchedEffect(Unit) {
        vm.getAllPhotos()
    }

    val list = vm.allPhotos.observeAsState().value

    Log.d("STLog", "Photos List from Screen: ${list}")


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomButton(title = "Back") {
            navController.navigate(Screen.HomeScreen.route)
        }
    }

}