package com.example.myapplication.data.model.mapper

import android.util.Log
import com.example.myapplication.data.model.NewsFeedResponseDto
import com.example.myapplication.domain.FeedPost
import com.example.myapplication.domain.StatisticItem
import com.example.myapplication.domain.StatisticType
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.absoluteValue

class NewsFeedMapper {
    fun mapResponseToPosts(responseDto: NewsFeedResponseDto?): List<FeedPost> {
        val result = mutableListOf<FeedPost>()
        val posts = responseDto?.newsFeedContent?.posts
        val groups = responseDto?.newsFeedContent?.groups
        if (posts == null || groups == null) {
            Log.d("mytag", "null server answer $responseDto")
            return emptyList()
        }
        for (post in posts) {
            val group = groups.find { it.id == post.communityId.absoluteValue } ?: break
            val feedPost = FeedPost(
                id = post.postId,
                communityName = group.name,
                publicationDate = mapTimestampToDate(post.date * 1000),
                communityImageUrl = group.imageUrl,
                contentText = post.text,
                contentImageUrl = post.attachments?.firstOrNull()?.photo?.photoUrls?.lastOrNull()?.url,
                statistic = listOf(
                    StatisticItem(
                        type = StatisticType.LIKES,
                        count = post.likes.count
                    ),
                    StatisticItem(
                        type = StatisticType.VIEWS,
                        count = post.views.count
                    ),
                    StatisticItem(
                        type = StatisticType.SHARES,
                        count = post.reposts.count
                    ),

                    StatisticItem(
                        type = StatisticType.COMMENTS,
                        count = post.comments.count
                    )
                )
            )
            result.add(feedPost)
        }
        return result
    }
    private fun mapTimestampToDate(timesTape: Long): String {
        val date = Date(timesTape)
        return SimpleDateFormat("d MMMM yyyy, hh:mm", Locale.getDefault()).format(date)
    }

}