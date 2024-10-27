/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.ui.screen

import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.newsapp.ui.components.CustomButton
import com.example.newsapp.ui.components.LoadWebView
import com.example.newsapp.ui.navigation.Screen
import com.example.newsapp.viewmodel.AllNewsViewModel
import javax.inject.Inject

@Composable
fun NewsDetailsScreen(vm:AllNewsViewModel, onNavigate: (String) -> Unit = {}){
    val url= vm.newsURL.observeAsState().value

    val constrains = ConstraintSet {
        val btn_back = createRefFor("btn_back")
        val wv_news = createRefFor("wv_news")
        constrain(wv_news) {
            top.linkTo(parent.top)
            start.linkTo(parent.start, 8.dp)
            end.linkTo(parent.end, 8.dp)
            bottom.linkTo(btn_back.top, margin = 95.dp)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent

        }
        constrain(btn_back){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom, margin = 16.dp)
            width = Dimension.value(300.dp)
            height = Dimension.value(70.dp)
        }
    }

    ConstraintLayout(
        constraintSet = constrains,
        modifier = Modifier.fillMaxSize()) {

        CustomButton(
            modifier = Modifier
                .layoutId("btn_back"),
            title = "Back"
        ) {
            onNavigate(Screen.AllNewsScreen.route)
        }
        LoadWebView(
            url = url.toString(),
            modifier = Modifier
            .layoutId("wv_news"))
    }
}