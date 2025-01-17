package com.example.arfid
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ForumViewModel : ViewModel() {

    private val repository = ForumFunction()

    private val _posts = MutableStateFlow<List<Map<String, Any>>>(emptyList())
    val posts: StateFlow<List<Map<String, Any>>> get() = _posts

    // Funktion, um einen Beitrag hinzuzufügen
    fun addPost(title: String, content: String, author: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val success = repository.addPost(title, content, author)
            if (success) {
                fetchPosts() // Aktualisiert die Liste
            }
        }
    }

    // Funktion, um Beiträge zu laden
    fun fetchPosts() {
        viewModelScope.launch(Dispatchers.IO){
            val postList = repository.fetchPosts()
            withContext(Dispatchers.Main) {

            }
            _posts.value = repository.fetchPosts()
        }
    }
}
