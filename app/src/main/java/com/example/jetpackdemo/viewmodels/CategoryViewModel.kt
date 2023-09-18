package com.example.jetpackdemo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackdemo.repository.tweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: tweetRepository) : ViewModel() {
    val categories: StateFlow<List<String>>
    get() = repository.categories

    init {
        viewModelScope.launch {
            repository.getCategories()
        }
    }
}