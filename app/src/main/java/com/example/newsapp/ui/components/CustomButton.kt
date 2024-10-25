/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun CustomButton(modifier: Modifier = Modifier, title:String = "", onClick: ()-> Unit = {}) {


    Button(
        modifier = modifier
            .width(200.dp)
            .height(75.dp),
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(Color.DarkGray),
        onClick = onClick
    ) {

        Text(
            modifier = modifier,
            text = title,
            fontSize = 20.sp,
            color = Color.White
        )

    }


}