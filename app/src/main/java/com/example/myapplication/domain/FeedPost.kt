package com.example.myapplication.domain

data class FeedPost(
    val id: String,
    val communityName: String,
    val publicationDate: String,
    val communityImageUrl: String,
    val contentText: String,
    val contentImageUrl: String?,
    val statistic: List<StatisticItem>,
    val isFavourite: Boolean
)