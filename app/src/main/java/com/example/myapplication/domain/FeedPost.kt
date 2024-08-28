package com.example.myapplication.domain

import com.example.myapplication.R

data class FeedPost(
    val id: Int = 0,
    val communityName: String = "/dev/null",
    val publicationDate: String = "14:00",
    val avatarResId: Int = R.drawable.post_comunity_thumbnail,
    val contentText: String = "Применение этих отступов к основному содержимому экрана (Box в данном случае) гарантирует, что ваше содержимое не",
    val contentImageResId: Int = R.drawable.baseline_auto_awesome_24,
    val statistic: List<StatisticItem> = listOf(
        StatisticItem(type = StatisticType.VIEWS, 99),
        StatisticItem(type = StatisticType.SHARES, 9),
        StatisticItem(type = StatisticType.COMMENTS, 10),
        StatisticItem(type = StatisticType.LIKES, 340),
    )
)