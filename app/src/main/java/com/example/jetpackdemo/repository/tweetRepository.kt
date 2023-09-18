package com.example.jetpackdemo.repository

import androidx.compose.runtime.MutableState
import com.example.jetpackdemo.Category
import com.example.jetpackdemo.api.tweestyApi
import com.example.jetpackdemo.models.tweetListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class tweetRepository @Inject constructor(private val tweestyApi: tweestyApi) {

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
        get() = _categories

    private val _tweets = MutableStateFlow<List<tweetListItem>>(emptyList())
    val tweets: StateFlow<List<tweetListItem>>
    get() = _tweets

    suspend fun getCategories() {
        val response = tweestyApi.getCategories()
        if (response.isSuccessful && response.body() != null) {
            _categories.emit(response.body()!!)
        }
    }

    suspend fun getTweets(category: String) {
        val response = tweestyApi.getTweets("tweets[?(@.category==\"$category\")]")
        if (response.isSuccessful && response.body() != null) {
            _tweets.emit(response.body()!!)
        }
    }
}