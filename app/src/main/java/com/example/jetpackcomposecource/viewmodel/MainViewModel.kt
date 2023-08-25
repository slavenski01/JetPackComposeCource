package com.example.jetpackcomposecource.viewmodel

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackcomposecource.domain.FeedNews
import com.example.jetpackcomposecource.domain.StatisticItem

class MainViewModel : ViewModel() {
    private val _isFollowing = MutableLiveData<Boolean>()
    val isFollowing: LiveData<Boolean> = _isFollowing

    fun changeFollowingStatus() {
        val wasFollowing = _isFollowing.value ?: false
        _isFollowing.value = !wasFollowing
    }

    private val _feedNews = MutableLiveData(FeedNews())
    val feedNews: LiveData<FeedNews> = _feedNews

    fun updateCount(item: StatisticItem) {
        val oldStatistic = feedNews.value?.statistics ?: throw IllegalStateException()
        val newStatistic = oldStatistic.toMutableStateList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == item.type) {
                    oldItem.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }
        _feedNews.value = feedNews.value?.copy(statistics = newStatistic)
    }
}