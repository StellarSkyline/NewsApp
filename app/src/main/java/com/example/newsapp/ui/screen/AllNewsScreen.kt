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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.newsapp.ui.navigation.Screen
import com.example.newsapp.viewmodel.AllNewsViewModel

@Composable
fun AllNewsScreen(navController: NavController, vm:AllNewsViewModel) {
    //val vm:AllNewsViewModel = hiltViewModel()
    var isSpinnerVisible:Boolean by remember {
        mutableStateOf(true)
    }

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

        }

        constrain(rv_list) {
            top.linkTo(tv_title.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent
        }

        constrain(include_spinner) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        }

        constrain(btn_back) {
            top.linkTo(rv_list.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.value(300.dp)
            height = Dimension.value(70.dp)
        }
    }

    ConstraintLayout(
        constraintSet = constraints,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Text(modifier =
        Modifier
            .layoutId("tv_title")
            .padding(top = 32.dp),
            text = "All News Screen",
            fontSize = 30.sp,
            color = Color.Blue)

        LazyColumn(
            modifier = Modifier
                .layoutId("rv_list")
                .padding(top = 32.dp)
        ) {
            if(!list.isNullOrEmpty()) isSpinnerVisible = false
            items(list ?: emptyList()) { item ->
                Text(text = item.title, modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .clickable {
                        vm.newsURL.value = item.url
                        navController.navigate(Screen.NewsDetailsScreen.route)
                    })
                Divider(modifier = Modifier.padding(top = 16.dp))
            }

        }

        Button(
            modifier = Modifier
                .layoutId("btn_back")
                .padding(top = 32.dp),

            onClick = {
                navController.navigate(Screen.HomeScreen.route)
            }
        ) {
            Text(text = "Back")
        }
        if(isSpinnerVisible) IncludeSpinner(modifier = Modifier.layoutId("include_spinner"))
    }
}

