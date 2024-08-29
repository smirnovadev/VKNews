package com.example.myapplication.ui.theme

import com.example.myapplication.domain.FeedPost

sealed class NewsFeedScreenState {
    object Initial: NewsFeedScreenState()
    data class Posts(val posts: List<FeedPost>): NewsFeedScreenState()

}