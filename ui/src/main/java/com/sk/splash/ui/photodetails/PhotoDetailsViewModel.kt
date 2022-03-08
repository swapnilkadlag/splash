package com.sk.splash.ui.photodetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.sk.splash.data.models.UIPhotoDetails
import com.sk.splash.data.models.UIResult
import com.sk.splash.data.repository.Repository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PhotoDetailsViewModel @AssistedInject constructor(
    private val repository: Repository,
    @Assisted private val photoId: String,
) : ViewModel() {
    @AssistedFactory
    interface Factory {
        fun create(photoId: String): PhotoDetailsViewModel
    }

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun provideFactory(
            assistedFactory: Factory,
            photoId: String,
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return assistedFactory.create(photoId) as T
            }
        }
    }

    private var _photoDetails: MutableStateFlow<UIPhotoDetails?> = MutableStateFlow(null)
    val photoDetails: StateFlow<UIPhotoDetails?> get() = _photoDetails

    init {
        viewModelScope.launch {
            when (val result = repository.getPhoto(photoId)) {
                is UIResult.Success -> _photoDetails.value = result.data
                is UIResult.Error -> {}
            }
        }
    }

    fun markFavorite() {
        viewModelScope.launch {
            photoDetails.value?.let {
                if (it.saved) {
                    repository.removeFavouritePhoto(it.id)
                } else {
                    repository.saveFavouritePhoto(it)
                }
            }
        }
    }
}