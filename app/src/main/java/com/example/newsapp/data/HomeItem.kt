/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

data class HomeItem(
    val title: String = "Title",
    val image:ImageVector = Icons.Default.Home,
    val route:String = ""
)
