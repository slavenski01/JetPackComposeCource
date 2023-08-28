package com.example.jetpackcomposecource.navigation

sealed class Screen(
    val route: String
) {
    object NewFeed: Screen(ROUTE_NEW_FEED)
    object Favourite: Screen(ROUTE_FAVOURITE)
    object Profile: Screen(ROUTE_PROFILE)

    private companion object {
        const val ROUTE_NEW_FEED = "news_feed"
        const val ROUTE_FAVOURITE = "favourite"
        const val ROUTE_PROFILE = "profile"
    }
}
