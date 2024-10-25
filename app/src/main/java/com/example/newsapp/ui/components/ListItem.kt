/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Computer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.data.DataItem

@Composable
@Preview
fun ListItem(modifier: Modifier = Modifier, item: DataItem = DataItem(), onClick: () -> Unit = {}) {

    Card(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(70.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(Color.DarkGray)

    ) {
        Row(
            modifier = modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = modifier
                    .size(70.dp)
                    .padding(start = 16.dp),
                imageVector = Icons.Default.Computer,
                contentDescription = "Computer Icon",
                colorFilter = ColorFilter.tint(Color.White)
            )

            Text(
                modifier = modifier
                    .padding(start = 16.dp, end = 8.dp)
                    .fillMaxWidth(),
                text = item.title,
                fontSize = 12.sp,
                color = Color.White,
                lineHeight = 12.sp
            )
        }

    }

}