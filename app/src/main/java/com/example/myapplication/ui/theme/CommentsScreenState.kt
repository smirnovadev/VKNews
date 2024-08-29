package com.example.myapplication.ui.theme

import com.example.myapplication.domain.FeedPost
import com.example.myapplication.domain.PostComment

sealed class CommentsScreenState {
    object Initial : CommentsScreenState()
    data class Comments(
        val feedPost: FeedPost,
        val comments: List<PostComment>
    ) : CommentsScreenState()

}