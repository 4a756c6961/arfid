package com.example.arfid

//Datenmodel zum Kommentaren auf Posts
data class Comment(
    val id: String? = null,
    val content: String? = null,
    val author: String? = null,
    val timestamp: Long? = null
)