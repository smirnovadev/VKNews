package com.example.myapplication.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.myapplication.R

sealed class  NavigationItem(
    val title: Int,
    val icon: ImageVector
) {
    object Home: NavigationItem(
        title = R.string.navigation_item_main,
        icon = Icons.Outlined.Home
    )
    object Favorite: NavigationItem(
        title = R.string.navigation_item_favorite,
        icon = Icons.Outlined.Favorite
    )
    object Profile: NavigationItem(
        title = R.string.navigation_item_profile,
        icon = Icons.Outlined.Person
    )
}

