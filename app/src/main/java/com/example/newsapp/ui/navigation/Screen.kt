/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.ui.navigation

sealed class Screen(val route:String) {
    object HomeScreen: Screen("home_screen")

    //News Routes
    object AllNewsGraph: Screen("all_news_graph")
    object AllNewsScreen: Screen("all_news_screen")
    object NewsDetailsScreen: Screen("news_details_screen")


    //Photos Routes
    object PhotosGraph: Screen("photos_graph")
    object PhotosScreen:Screen("photos_screen")
    object PhotoDetailsScreen:Screen("photo_details_screen")

}