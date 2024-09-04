package com.example.myapplication.navigation

import android.net.Uri
import com.example.myapplication.domain.FeedPost
import com.google.gson.Gson

sealed class Screen(
    val route: String
) {
    object NewsFeed : Screen(ROUTE_NEWS_FEED)
    object Favorite : Screen(ROUTE_FAVORITE)
    object Profile : Screen(ROUTE_PROFILE)
    object Home : Screen(ROUTE_HOME)
    object Comments : Screen(ROUTE_COMMENT) {

        private const val ROUTE_FOR_ARGS = "comments"
        fun getRouteWithArgs(feedPost: FeedPost): String {
            val feedPostJson = Gson().toJson(feedPost)
            return "$ROUTE_FOR_ARGS/${feedPostJson.endcode()}"
        }
    }

    companion object {
        const val KEY_FEED_POST = "feed_post"
        const val ROUTE_HOME = "home"
        const val ROUTE_COMMENT = "comments/{$KEY_FEED_POST}"
        const val ROUTE_NEWS_FEED = "news_feed"
        const val ROUTE_FAVORITE = "favorite"
        const val ROUTE_PROFILE = "profile"
    }
}

fun String.endcode(): String {
    return Uri.encode(this)
}