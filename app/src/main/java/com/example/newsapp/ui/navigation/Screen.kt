/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.ui.navigation

sealed class Screen(val route:String) {
    object HomeScreen: Screen("home_screen")
    object AllNewsScreen: Screen("all_news_screen")
}