package com.example.myapplication.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.myapplication.R
import com.example.myapplication.navigation.Screen

sealed class  NavigationItem(
    val screen: Screen,
    val title: Int,
    val icon: ImageVector
) {
    object Home: NavigationItem(
        screen = Screen.NewsFeed,
        title = R.string.navigation_item_main,
        icon = Icons.Outlined.Home
    )
    object Favorite: NavigationItem(
        screen = Screen.Favorite,
        title = R.string.navigation_item_favorite,
        icon = Icons.Outlined.Favorite
    )
    object Profile: NavigationItem(
        screen = Screen.Profile,
        title = R.string.navigation_item_profile,
        icon = Icons.Outlined.Person
    )
}

