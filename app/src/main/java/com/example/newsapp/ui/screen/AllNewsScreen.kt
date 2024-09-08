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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun AllNewsScreenPreview(navController: NavController = rememberNavController()) {
    val constraints = ConstraintSet {
        val tv_title = createRefFor("tv_title")
        val btn_back = createRefFor("btn_back")

        constrain(tv_title) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)

        }

        constrain(btn_back) {
            top.linkTo(tv_title.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
        }
    }

    ConstraintLayout(
        constraintSet = constraints,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Text(modifier =
        Modifier.layoutId("tv_title"),
            text = "All News Screen",
            fontSize = 30.sp,
            color = Color.Blue)

        Button(onClick = {
            navController.navigate("home_screen")
        },
            modifier = Modifier
                .layoutId("btn_back")
                .padding(16.dp)) {
            Text(text = "Back",
                fontSize = 10.sp)

        }
        
    }

}

