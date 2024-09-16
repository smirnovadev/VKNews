package com.example.myapplication.presentation.news


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.model.mapper.NewsFeedMapper
import com.example.myapplication.domain.FeedPost
import com.example.myapplication.domain.StatisticItem

class NewsFeedViewMode(application: Application) : AndroidViewModel(application) {


    private val initialState = NewsFeedScreenState.Initial
    private val _screenState = MutableLiveData<NewsFeedScreenState>(initialState)
    val screenState: LiveData<NewsFeedScreenState> = _screenState
    private val mapper = NewsFeedMapper()

    fun updateCount(item: StatisticItem, feedPost: FeedPost) {

        val currentState = screenState.value
        if (currentState !is NewsFeedScreenState.Posts) return

        val oldPosts = currentState.posts.toMutableList()
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
        val newFeedPost = feedPost.copy(statistic = newStatistic)

        val newPosts = oldPosts.apply {
            replaceAll {
                if (it.id == newFeedPost.id) {
                    newFeedPost
                } else {
                    it
                }
            }
        }
        _screenState.value = NewsFeedScreenState.Posts(posts = newPosts)
    }

    fun remove(feedPost: FeedPost) {

        val currentState = screenState.value
        if (currentState !is NewsFeedScreenState.Posts) return
        val oldPosts = currentState.posts.toMutableList()
        oldPosts.remove(feedPost)
        _screenState.value = NewsFeedScreenState.Posts(posts = oldPosts)
    }
}