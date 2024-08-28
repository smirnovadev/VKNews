package com.example.myapplication.ui.theme

import com.example.myapplication.domain.FeedPost
import com.example.myapplication.domain.PostComment

sealed class HomeScreenState {
    object Initial: HomeScreenState()
    data class Posts(val posts: List<FeedPost>): HomeScreenState()
    data class Comments(val feedPost: FeedPost, val comments: List<PostComment>): HomeScreenState()
}