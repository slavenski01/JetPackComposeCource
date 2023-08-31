package com.example.jetpackcomposecource.ui.vk

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.jetpackcomposecource.navigation.AppNavGraph
import com.example.jetpackcomposecource.navigation.rememberNavigationState
import com.example.jetpackcomposecource.viewmodel.MainViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    viewModel: MainViewModel
) {
    val navigationState = rememberNavigationState()

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry
                        by navigationState.navHostController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                val bottomButtons = listOf(
                    NavigationItem.Home,
                    NavigationItem.Favourite,
                    NavigationItem.Profile,
                )
                bottomButtons.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.screen.route,
                        onClick = {
                            navigationState.navigateTo(item.screen.route)
                        },
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = null
                            )
                        },
                        label = { Text(text = item.title) },
                    )
                }
            }
        },
    ) {
        AppNavGraph(
            navHostController = navigationState.navHostController,
            homeScreenContent = { HomeScreen(viewModel = viewModel) },
            favouriteScreenContent = { TextCounter(name = "Favourite") },
            profileScreenContent = { TextCounter(name = "Profile") }
        )
    }
}

@Composable
private fun TextCounter(name: String) {
    var count by rememberSaveable {
        mutableIntStateOf(0)
    }
    Text(
        modifier = Modifier.clickable { count++ },
        text = "$name Count: $count"
    )
}