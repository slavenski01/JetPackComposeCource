package com.example.jetpackcomposecource.domain

import com.example.jetpackcomposecource.R

data class NewsComment(
    val id: Int,
    val authorName: String = "",
    val authorAvatarId: Int = R.drawable.ic_like,
    val commentText: String = "some comment",
    val publicationDate: String = "30.08.2023"
)
