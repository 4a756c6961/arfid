package com.example.arfid

import com.google.firebase.Firebase
import com.google.firebase.database.database
import kotlinx.coroutines.tasks.await

class ForumFunction {
    private val database = Firebase.database.reference

    // Funktion zum Hinzufügen eines Beitrags
    suspend fun addPost(title: String, content: String, author: String): Boolean {
        return try {
            val postId = database.child("posts").push().key ?: return false
            val post = mapOf(
                "id" to postId,
                "title" to title,
                "content" to content,
                "author" to author,
                "timestamp" to System.currentTimeMillis()
            )
            database.child("posts").child(postId).setValue(post).await()
            true
        } catch (e: Exception) {
            false
        }
    }

    // Funktion zum Abrufen aller Beiträge
    suspend fun fetchPosts(): List<Map<String, Any>> {
        return try {
            val snapshot = database.child("posts").get().await()
            snapshot.children.mapNotNull { it.value as? Map<String, Any> }
        } catch (e: Exception) {
            emptyList()
        }
    }
}