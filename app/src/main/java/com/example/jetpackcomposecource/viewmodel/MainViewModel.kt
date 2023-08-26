package com.example.jetpackcomposecource.viewmodel

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackcomposecource.domain.FeedNews
import com.example.jetpackcomposecource.domain.InstagramModel
import com.example.jetpackcomposecource.domain.StatisticItem
import kotlin.random.Random

class MainViewModel : ViewModel() {

    private val initialList = mutableListOf<InstagramModel>().apply {
        repeat(500) {
            add(
                InstagramModel(
                    id = it,
                    title = "Title: $it",
                    isFollowed = Random.nextBoolean()
                )
            )
        }
    }

    private val _models = MutableLiveData<List<InstagramModel>>(initialList)
    val models: LiveData<List<InstagramModel>> = _models

    fun changeFollowingStatus(model: InstagramModel) {
        val modifiedList = _models.value?.toMutableStateList() ?: mutableListOf()
        modifiedList.replaceAll {
            if (it == model) {
                it.copy(isFollowed = !it.isFollowed)
            } else {
                it
            }
        }
        _models.value = modifiedList
    }


    fun deleteInstaModel(model: InstagramModel) {
        val modifiedList = _models.value?.toMutableStateList() ?: mutableListOf()
        modifiedList.remove(model)
        _models.value = modifiedList
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