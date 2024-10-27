/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
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
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.ui.components.CustomButton
import com.example.newsapp.ui.components.PhotoGridItem
import com.example.newsapp.ui.navigation.Screen
import com.example.newsapp.viewmodel.PhotosViewModel

@Composable
fun PhotosScreen(onNavigate:(String) -> Unit = {}) {
    val vm = hiltViewModel<PhotosViewModel>()
    LaunchedEffect(Unit) {
        vm.getAllPhotos()
    }

    val list = vm.allPhotos.observeAsState().value

    Log.d("STLog", "Photos List from Screen: ${list}")

    //Set up constraint layout
    val constraints = ConstraintSet {
        val rv_grid = createRefFor("rv_grid")
        val btn_back = createRefFor("btn_back")
        val tv_title = createRefFor("tv_title")

        constrain(tv_title) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent

        }

        constrain(rv_grid) {
            top.linkTo(tv_title.bottom)
            start.linkTo(parent.start, 16.dp)
            end.linkTo(parent.end, 16.dp)
        }

        constrain(btn_back) {
            bottom.linkTo(parent.bottom, 16.dp)
            start.linkTo(parent.start, 16.dp)
            end.linkTo(parent.end, 16.dp)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
    }

    ConstraintLayout(
        constraintSet = constraints,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            modifier = Modifier.layoutId("tv_title"),
            text = "All News API",
            fontSize = 30.sp,
            color = Color.DarkGray,
            textAlign = TextAlign.Center
        )

        //Test
//        if(!list.isNullOrEmpty()) {
//            PhotoGridItem(
//                imageUrl = list[0].src.medium
//            )
//        }

        CustomButton(modifier = Modifier
            .layoutId("btn_back"),
            title = "Back") {
            onNavigate(Screen.HomeScreen.route)
        }
    }
}

@Composable
@Preview
fun PhotosScreenPreview() {
    PhotosScreen()
}
