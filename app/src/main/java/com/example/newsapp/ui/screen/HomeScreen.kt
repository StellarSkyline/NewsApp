/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import com.example.newsapp.ui.navigation.Screen


@Composable
fun HomeScreen(navController: NavController = NavController(LocalContext.current)) {
    val constraints =  ConstraintSet {
        val tv_title = createRefFor("tv_title")
        val btn_next = createRefFor("btn_next")

        constrain(tv_title) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent
        }

        constrain(btn_next) {
            top.linkTo(tv_title.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent


        }
    }

    ConstraintLayout(
        constraintSet = constraints,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)) {

        titleText(
            title = "NewsApp Home Screen",
            modifier = Modifier.layoutId("tv_title"))

        button(
            text = "All News Screen",
            modifier = Modifier
                .layoutId("btn_next")
                .padding(top = 32.dp, start = 16.dp, end = 16.dp),
            onClick = { navController.navigate(Screen.AllNewsGraph.route) }
        )
    }

}

@Composable
fun titleText(title:String, modifier: Modifier) {
    Text(
        text = title,
        fontSize = 30.sp,
        color = Color.Blue,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}

@Composable
fun button(text:String, modifier: Modifier, onClick: () -> Unit) {
    Button(
        modifier = modifier,
        onClick = onClick,

        ) {
        Text(text = text,
            fontSize = 20.sp
        )

    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}
