package com.sk.splash.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sk.splash.data.utils.models.UICollection
import com.sk.splash.data.utils.models.UIPhoto
import com.sk.splash.data.utils.models.UIResult
import com.sk.splash.data.utils.repository.Repository
import com.sk.splash.ui.common.PageLoader
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    val latestPhotosLoader = PageLoader(
        scope = viewModelScope,
        load = { page, _ ->
            when (val res = repository.getLatestPhotos(page)) {
                is UIResult.Success -> res.data
                else -> listOf()
            }
        },
    )

    val popularPhotosLoader = PageLoader(
        scope = viewModelScope,
        load = { page, _ ->
            when (val res = repository.getPopularPhotos(page)) {
                is UIResult.Success -> res.data
                else -> listOf()
            }
        },
    )

    val featuredCollectionsLoader = PageLoader(
        scope = viewModelScope,
        load = { page, _ ->
            when (val res = repository.getFeaturedCollections(page)) {
                is UIResult.Success -> res.data
                else -> listOf()
            }
        }
    )
}
