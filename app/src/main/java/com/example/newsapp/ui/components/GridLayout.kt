/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ConnectedTv
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun GridLayout(modifier: Modifier = Modifier) {

}

@Composable
@Preview
fun GridItem() {

    Card(
        modifier = Modifier.size(150.dp),
        elevation = CardDefaults.cardElevation(16.dp)
    ){

        Column() {

            Image(imageVector = Icons.Default.ConnectedTv,
                contentDescription = "Image icon" )

        }

    }

}