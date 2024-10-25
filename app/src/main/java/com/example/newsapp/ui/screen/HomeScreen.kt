/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ConnectedTv
import androidx.compose.material.icons.filled.ImageSearch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.navigation.NavController
import com.example.newsapp.data.HomeItem
import com.example.newsapp.ui.components.GridItem
import com.example.newsapp.ui.navigation.Screen


@Composable
fun HomeScreen(navController: NavController) {
    val constraints =  ConstraintSet {
        val tv_title = createRefFor("tv_title")
        val grid_layout = createRefFor("grid_layout")

        constrain(tv_title) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent

        }

        constrain(grid_layout) {
            top.linkTo(tv_title.bottom, 16.dp)
            start.linkTo(parent.start, 8.dp)
            end.linkTo(parent.end, 8.dp)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent
        }

    }

    val homeList = mutableListOf<HomeItem>()
    homeList.add(HomeItem("News API", Icons.Default.ConnectedTv, Screen.AllNewsGraph.route))
    homeList.add(HomeItem("Photos API", Icons.Default.ImageSearch))
    homeList.add(HomeItem("Test Tile"))

    

    ConstraintLayout(
        constraintSet = constraints,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)) {

        Text(
            modifier = Modifier.layoutId("tv_title"),
            text = "Home Screen",
            fontSize = 30.sp,
            color = Color.DarkGray,
            textAlign = TextAlign.Center
        )

        LazyVerticalGrid(
            modifier = Modifier.layoutId("grid_layout"),
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(32.dp),
        ) {
            items(homeList.size) {
                GridItem(homeItem = homeList[it]) {
                    if(homeList[it].route.isNotEmpty()) navController.navigate(homeList[it].route)
                }
            }
        }
    }

}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen(navController = NavController(LocalContext.current))
}
