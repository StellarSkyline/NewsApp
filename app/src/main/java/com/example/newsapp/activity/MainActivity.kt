/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.ui.navigation.AppNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           MaterialTheme {
               Scaffold(
                   topBar = {
                       TopAppBar(
                           title = { Text(text = "Seth App", fontSize = 16.sp, color = Color.White) },
                           colors = TopAppBarDefaults.topAppBarColors(Color.Gray)
                       )
                   },
               ) { paddingValues ->
                   AppNavigation(paddingValues)
               }
           }
        }
    }
}

