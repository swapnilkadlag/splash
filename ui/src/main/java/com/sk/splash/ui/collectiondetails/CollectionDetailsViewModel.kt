package com.sk.splash.ui.collectiondetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.sk.splash.data.models.UICollectionDetails
import com.sk.splash.data.models.UIResult
import com.sk.splash.data.repository.Repository
import com.sk.splash.ui.photodetails.PhotoDetailsViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CollectionDetailsViewModel @AssistedInject constructor(
    private val repository: Repository,
    @Assisted private val collectionId: String,
) : ViewModel() {
    @AssistedFactory
    interface Factory {
        fun create(collectionId: String): CollectionDetailsViewModel
    }

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun provideFactory(
            assistedFactory: Factory,
            collectionId: String,
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return assistedFactory.create(collectionId) as T
            }
        }
    }

    private var _collectionDetails: MutableStateFlow<UICollectionDetails?> = MutableStateFlow(null)
    val collectionDetails: StateFlow<UICollectionDetails?> get() = _collectionDetails

    val collectionPhotos = repository.getCollectionPhotos(collectionId).cachedIn(viewModelScope)

    init {
        viewModelScope.launch {
            when (val result = repository.getCollection(collectionId)) {
                is UIResult.Success -> _collectionDetails.value = result.data
                is UIResult.Error -> {}
            }
        }
    }
}