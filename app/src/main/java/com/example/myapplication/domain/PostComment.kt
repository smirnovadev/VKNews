package com.example.myapplication.domain

import com.example.myapplication.R

data class PostComment (
    val id: Int,
    val authorName: String = "Anna",
    val authorAvatarId: Int = R.drawable.baseline_co_present_24,
    val commentText: String = "очень круто",
    val publicationDate: String = "14:00"
)