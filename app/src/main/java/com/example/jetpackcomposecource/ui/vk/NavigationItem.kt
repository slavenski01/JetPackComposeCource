package com.example.jetpackcomposecource.ui.vk

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.jetpackcomposecource.navigation.Screen

sealed class NavigationItem(
    val screen: Screen,
    val title: String,
    val icon: ImageVector
) {
    object Home : NavigationItem(
        screen = Screen.NewFeed,
        title = "Главная",
        icon = Icons.Outlined.Home
    )

    object Favourite : NavigationItem(
        screen = Screen.Favourite,
        title = "Избранное",
        icon = Icons.Outlined.Favorite
    )

    object Profile : NavigationItem(
        screen = Screen.Profile,
        title = "Профиль",
        icon = Icons.Outlined.Person
    )
}