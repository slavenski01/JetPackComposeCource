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

    private val mockFeeds = mutableListOf<FeedNews>().apply {
        repeat(10) {
            add(FeedNews(it))
        }
    }

    private val _feedNews = MutableLiveData(mockFeeds.toList())
    val feedNews: LiveData<List<FeedNews>> = _feedNews

    fun updateVkStatCount(item: FeedNews, statisticItem: StatisticItem) {
        val newListFeeds =
            _feedNews.value?.toMutableStateList() ?: throw java.lang.IllegalStateException()

        newListFeeds.replaceAll {
            if (it == item) {
                val newStats = it.statistics.toMutableStateList()
                newStats.replaceAll { stat ->
                    if (stat == statisticItem) {
                        val newStat = stat.copy(count = stat.count + 1)
                        newStat
                    } else {
                        stat
                    }
                }
                it.copy(statistics = newStats)
            } else {
                it
            }
        }
        _feedNews.value = newListFeeds
    }

    fun removeVkItem(item: FeedNews) {
        val newFeeds =
            _feedNews.value?.toMutableStateList() ?: throw java.lang.IllegalStateException()
        newFeeds.apply {
            remove(item)
        }
        _feedNews.value = newFeeds
    }
}