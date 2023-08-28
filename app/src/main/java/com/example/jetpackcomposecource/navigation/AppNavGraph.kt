package com.example.jetpackcomposecource.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    homeScreenContent: @Composable () -> Unit,
    favouriteScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.NewFeed.route
    ) {
        composable(
            route = Screen.NewFeed.route,
        ) {
            homeScreenContent()
        }
        composable(
            route = Screen.Favourite.route,
        ) {
            favouriteScreenContent()
        }
        composable(
            route = Screen.Profile.route,
        ) {
            profileScreenContent()
        }
    }
}