/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.ui.screen.AllNewsScreenPreview
import com.example.newsapp.ui.screen.HomeScreen

@Composable
fun AppNavigation() {
    //Navigation
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home_screen", builder = {

        composable("home_screen") {
            HomeScreen(navController)
        }

        composable("all_news_screen") {
            AllNewsScreenPreview(navController)
        }

    } )
}