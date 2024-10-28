/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
@Preview
fun PhotoGridItem(modifier:Modifier = Modifier, imageUrl:String = "", onClick: () -> Unit = {}) {
    Card(
        modifier = modifier
            .width(150.dp)
            .height(150.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {

        Column(
            modifier = modifier
                .background(Color.DarkGray)
                .fillMaxSize()
                .clickable { onClick() },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            GlideImage(
                modifier = modifier
                    .width(150.dp)
                    .height(150.dp)
                    .padding(10.dp),
                model = imageUrl,
                contentDescription = "Photo",
                contentScale = ContentScale.Crop
            )
        }


    }
}