package com.sk.splash.ui.search

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.sk.splash.data.models.UICollection
import com.sk.splash.data.models.UIPhoto
import com.sk.splash.data.models.UIUser
import com.sk.splash.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: Repository,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery get() = _searchQuery.asStateFlow()
    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    var searchedPhotos = repository.searchPhotos(_searchQuery).cachedIn(viewModelScope)

    var searchedCollections = repository.searchCollections(_searchQuery).cachedIn(viewModelScope)

    var searchedUsers = repository.searchUsers(_searchQuery).cachedIn(viewModelScope)
}