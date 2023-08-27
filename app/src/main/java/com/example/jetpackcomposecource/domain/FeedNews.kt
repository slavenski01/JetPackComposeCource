package com.example.jetpackcomposecource.domain

import com.example.jetpackcomposecource.R

data class FeedNews(
    val id: Int,
    val communityName: String = "slavenskiHub",
    val publicationDate: String = "15:00",
    val avatarResId: Int = R.drawable.ic_instagram_logo,
    val contentText: String = "text very strong very big very chik chik",
    val contentImageResId: Int = R.drawable.ic_launcher_background,
    val statistics: List<StatisticItem> = listOf(
        StatisticItem(StatisticType.VIEWS),
        StatisticItem(StatisticType.SHARES),
        StatisticItem(StatisticType.COMMENTS),
        StatisticItem(StatisticType.LIKES),
    )
)