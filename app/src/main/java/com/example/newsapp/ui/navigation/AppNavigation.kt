/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.extension.sharedViewModel
import com.example.newsapp.ui.screen.AllNewsScreen
import com.example.newsapp.ui.screen.HomeScreen
import com.example.newsapp.ui.screen.NewsDetailsScreen
import com.example.newsapp.ui.screen.PhotosScreen
import com.example.newsapp.viewmodel.AllNewsViewModel

@Composable
fun AppNavigation(paddingValues:PaddingValues) {
    //Navigation
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route, builder = {

        composable(Screen.HomeScreen.route) {
            HomeScreen{ passedRoute ->
                navController.navigate(passedRoute)
            }
        }
        //Seperate Nav Graph to share VM between All News and All news Details
        navigation(startDestination = Screen.AllNewsScreen.route, route = Screen.AllNewsGraph.route) {
            composable(Screen.AllNewsScreen.route) { entry ->
                val viewModel = entry.sharedViewModel<AllNewsViewModel>(navController)
                AllNewsScreen(viewModel) { passedRoute ->
                    navController.navigate(passedRoute)
                }
            }
            composable(Screen.NewsDetailsScreen.route) { entry ->
                val viewModel = entry.sharedViewModel<AllNewsViewModel>(navController)
                NewsDetailsScreen(viewModel) { passedRoute ->
                    navController.navigate(passedRoute)
                }
            }
        }
        composable(Screen.PhotosScreen.route) {
           PhotosScreen{ passedRoute ->
               navController.navigate(passedRoute)
           }
        }
    } )
}

