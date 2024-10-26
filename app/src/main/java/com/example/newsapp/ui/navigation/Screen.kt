/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.ui.navigation

sealed class Screen(val route:String) {
    object HomeScreen: Screen("home_screen")

    //News Routes
    object AllNewsScreen: Screen("all_news_screen")
    object NewsDetailsScreen: Screen("news_details_screen")
    object AllNewsGraph: Screen("all_news_graph")

    //Photos Routes

    object PhotosScreen:Screen("photos_screen")

}