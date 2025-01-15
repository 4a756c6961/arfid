package com.example.arfid

data class Post(
    val id: Int,
    val title: String,
    val content: String,
    val author: String,
    val timestamp: String
)

data class Comment(
    val postId: Int,
    val content: String,
    val author: String,
    val timestamp: String
)
