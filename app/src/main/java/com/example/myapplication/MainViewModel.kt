package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.FeedPost
import com.example.myapplication.domain.StatisticItem

class MainViewModel : ViewModel() {
    private val sourseList = mutableListOf<FeedPost>().apply {
        repeat(10) {
            add(FeedPost(id = it))
        }
    }
    private val _feedPosts = MutableLiveData<List<FeedPost>>(sourseList)
    val feedPosts: LiveData<List<FeedPost>> = _feedPosts

    fun updateCount(item: StatisticItem, feedPost: FeedPost) {
        val oldPosts = feedPosts.value?.toMutableList() ?: mutableListOf()
        val oldStatistics = feedPost.statistic.toMutableList()
        val newStatistic = oldStatistics.apply {
            replaceAll { oldItem ->
                if (oldItem.type == item.type) {
                    oldItem.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }
        val newFeedPost = feedPost.copy(
            statistic = newStatistic
        )
        _feedPosts.value = oldPosts.apply {
            replaceAll {
                if (it.id == newFeedPost.id) {
                    newFeedPost
                } else {
                    it
                }
            }
        }


    }

    fun clearPost(feedPost: FeedPost) {
        val oldPosts = _feedPosts.value?.toMutableList() ?: mutableListOf()
        oldPosts.remove(feedPost)
        _feedPosts.value = oldPosts
    }
}