package com.example.myapplication.presentation.news

import com.example.myapplication.domain.FeedPost

sealed class NewsFeedScreenState {
    object Initial: NewsFeedScreenState()
    data class Posts(val posts: List<FeedPost>): NewsFeedScreenState()

}