/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.view

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.newsapp.ui.navigation.AppNavigation
import com.example.newsapp.ui.screen.AllNewsScreenPreview
import com.example.newsapp.ui.screen.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var vb:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        vb = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(vb.root)
        setContent {
            AppNavigation()
        }
    }
}

