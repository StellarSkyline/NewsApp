/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.ui.screen.AllNewsScreen
import com.example.newsapp.ui.screen.HomeScreen
import com.example.newsapp.ui.screen.NewsDetailsScreen
import com.example.newsapp.viewmodel.AllNewsViewModel

@Composable
fun AppNavigation() {
    //Navigation
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route, builder = {

        composable(Screen.HomeScreen.route) {
            HomeScreen(navController)
        }

        navigation(startDestination = Screen.AllNewsScreen.route, route = Screen.AllNewsGraph.route) {
            composable(Screen.AllNewsScreen.route) { entry ->
                val viewModel:AllNewsViewModel = hiltViewModel(entry)
                AllNewsScreen(navController, viewModel)
            }
            composable(Screen.NewsDetailsScreen.route) { entry ->
                val viewModel:AllNewsViewModel = if(navController.previousBackStackEntry != null) hiltViewModel(navController.previousBackStackEntry!!)
                else hiltViewModel(entry)
                NewsDetailsScreen(navController, viewModel)
            }

        }
    } )
}

//Extension function for shared view model
@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(
    navController: NavHostController,
): T {
    val navGraphRoute = destination.parent?.route ?: return viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}