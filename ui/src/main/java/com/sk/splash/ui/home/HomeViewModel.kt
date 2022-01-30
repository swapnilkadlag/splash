package com.sk.splash.ui.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.sk.splash.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    fun latestPhotos() = repository.getLatestPhotos().cachedIn(viewModelScope)
    fun popularPhotos() = repository.getPopularPhotos().cachedIn(viewModelScope)
    fun featuredCollections() = repository.getFeaturedCollections().cachedIn(viewModelScope)
}
