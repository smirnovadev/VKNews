package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.domain.FeedPost

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    favoriteScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit,
    newsFeedScreenContent: @Composable () -> Unit,
    commentsScreenContent: @Composable (FeedPost) -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route,
    ) {
        homeScreenNavGraph(
            newsFeedScreenContent = newsFeedScreenContent,
            commentsScreenContent = commentsScreenContent
        )

        composable(Screen.Favorite.route) {
            favoriteScreenContent()
        }
        composable(Screen.Profile.route) {
            profileScreenContent()
        }
    }
}
