/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.ui.screen

import android.util.Log
import android.webkit.WebView
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.newsapp.domain.repo.AllNewsRepo
import com.example.newsapp.ui.components.CustomButton
import com.example.newsapp.ui.components.ListItem
import com.example.newsapp.ui.navigation.Screen
import com.example.newsapp.viewmodel.AllNewsViewModel

@Composable
fun AllNewsScreen(vm:AllNewsViewModel, onNavigate:(String) -> Unit = {}) {
    var isSpinnerVisible:Boolean by remember { mutableStateOf(true) }

    //will only launch once
    LaunchedEffect(Unit) {
        vm.getAllNews()
    }

    val list = vm.allNews.observeAsState().value

    val constraints = ConstraintSet {
        val tv_title = createRefFor("tv_title")
        val rv_list = createRefFor("rv_list")
        val include_spinner = createRefFor("include_spinner")
        val btn_back = createRefFor("btn_back")

        constrain(tv_title) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent

        }

        constrain(rv_list) {
            top.linkTo(tv_title.bottom)
            bottom.linkTo(btn_back.top, 16.dp)
            start.linkTo(parent.start, 16.dp)
            end.linkTo(parent.end, 16.dp)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints

        }

        constrain(include_spinner) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        }

        constrain(btn_back) {
            bottom.linkTo(parent.bottom, 16.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
    }

    ConstraintLayout(
        constraintSet = constraints,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Text(
            modifier = Modifier.layoutId("tv_title"),
            text = "All News API",
            fontSize = 30.sp,
            color = Color.DarkGray,
            textAlign = TextAlign.Center
        )

        LazyColumn(
            modifier = Modifier
                .layoutId("rv_list")
                .padding(top = 32.dp)
        ) {
            if(!list.isNullOrEmpty()) isSpinnerVisible = false
            items(list ?: emptyList()) { item ->
                ListItem(modifier = Modifier, item = item) {
                    vm.newsURL.value = item.url
                    onNavigate(Screen.NewsDetailsScreen.route)
                }
            }

        }

        CustomButton(
            modifier = Modifier.layoutId("btn_back"),
            title = "Back"
        ) {
            onNavigate(Screen.HomeScreen.route)
        }

        if(isSpinnerVisible) IncludeSpinner(modifier = Modifier.layoutId("include_spinner"))
    }
}
