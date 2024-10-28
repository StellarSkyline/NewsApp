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
import com.example.newsapp.ui.screen.PhotoDetailsScreen
import com.example.newsapp.ui.screen.PhotosScreen
import com.example.newsapp.viewmodel.AllNewsViewModel
import com.example.newsapp.viewmodel.PhotosViewModel

@Composable
fun AppNavigation(paddingValues: PaddingValues) {
    //Navigation
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route, builder = {

        composable(Screen.HomeScreen.route) {
            HomeScreen { passedRoute ->
                navController.navigate(passedRoute)
            }
        }

        //News Navigation Graph
        navigation(
            startDestination = Screen.AllNewsScreen.route,
            route = Screen.AllNewsGraph.route
        ) {
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

        //Photos Navigation Graph
        navigation(
            startDestination = Screen.PhotosScreen.route,
            route = Screen.PhotosGraph.route
        ) {

            composable(Screen.PhotosScreen.route) { entry ->
                val viewModel = entry.sharedViewModel<PhotosViewModel>(navController)
                PhotosScreen(viewModel) { passedRoute ->
                    navController.navigate(passedRoute)
                }
            }

            composable(Screen.PhotoDetailsScreen.route) { entry ->
                val viewModel = entry.sharedViewModel<PhotosViewModel>(navController)
                PhotoDetailsScreen(viewModel) { passedRoute ->
                    navController.navigate(passedRoute)
                }
            }
        }
    })
}

