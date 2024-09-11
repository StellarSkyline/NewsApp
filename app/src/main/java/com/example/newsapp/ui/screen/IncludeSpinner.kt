/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun IncludeSpinner(modifier: Modifier) {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp),
            color = Color.DarkGray,
            trackColor = Color.Gray
        )
    }
}