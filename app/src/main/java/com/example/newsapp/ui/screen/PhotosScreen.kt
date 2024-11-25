/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.ui.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.ui.components.CustomButton
import com.example.newsapp.ui.components.PhotoGridItem
import com.example.newsapp.ui.navigation.Screen
import com.example.newsapp.viewmodel.PhotosViewModel

@Composable
fun PhotosScreen(vm:PhotosViewModel, onNavigate:(String) -> Unit = {}) {
    LaunchedEffect(Unit) {
        vm.getAllPhotos()
    }

    val list by vm.allPhotos.collectAsStateWithLifecycle()

    //Set up constraint layout
    val constraints = ConstraintSet {
        val rv_grid = createRefFor("rv_grid")
        val btn_back = createRefFor("btn_back")
        val tv_title = createRefFor("tv_title")
        val include_spinner = createRefFor("include_spinner")

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
            bottom.linkTo(btn_back.top, 16.dp)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        }

        constrain(btn_back) {
            bottom.linkTo(parent.bottom, 16.dp)
            start.linkTo(parent.start, 16.dp)
            end.linkTo(parent.end, 16.dp)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }

        constrain(include_spinner) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
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
            text = "Pexel API",
            fontSize = 30.sp,
            color = Color.DarkGray,
            textAlign = TextAlign.Center
        )

        LazyVerticalGrid(
            modifier = Modifier.layoutId("rv_grid"),
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if(list.isNotEmpty()) {
                items(list.size) { photo ->
                    PhotoGridItem(modifier = Modifier,imageUrl = list[photo].src.medium) {
                        vm.photo.value = list[photo]
                        onNavigate(Screen.PhotoDetailsScreen.route)
                    }
                }
            }
        }
        CustomButton(modifier = Modifier
            .layoutId("btn_back"),
            title = "Back") {
            onNavigate(Screen.HomeScreen.route)
        }

        if(list.isEmpty()) IncludeSpinner(modifier = Modifier.layoutId("include_spinner"))
    }
}