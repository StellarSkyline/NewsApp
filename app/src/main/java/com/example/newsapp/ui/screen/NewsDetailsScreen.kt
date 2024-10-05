/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.ui.screen

import android.util.Log
import android.webkit.WebView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.newsapp.viewmodel.AllNewsViewModel
import javax.inject.Inject

@Composable
fun NewsDetailsScreen(navController: NavController, vm:AllNewsViewModel){


    val url= vm.newsURL.observeAsState().value

    Column(modifier = Modifier
        .fillMaxSize()){

        if(url.isNullOrEmpty()) Box{}
        else Log.d("STLog", "URL: $url")
    }

}

@Composable
fun LoadWebView() {
    AndroidView(factory = {
        WebView(it).apply {
            loadUrl("https://www.google.com")
        }
    })
}