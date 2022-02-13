package com.sk.splash.ui.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.sk.splash.data.models.UIPhoto
import com.sk.splash.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    val latestPhotos = repository.getLatestPhotos().cachedIn(viewModelScope)
    val popularPhotos = repository.getPopularPhotos().cachedIn(viewModelScope)
    val featuredCollections = repository.getFeaturedCollections().cachedIn(viewModelScope)
}
