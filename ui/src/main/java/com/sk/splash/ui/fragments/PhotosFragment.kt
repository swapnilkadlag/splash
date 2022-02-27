package com.sk.splash.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.viewbinding.ViewBinding
import com.google.android.material.progressindicator.BaseProgressIndicator
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.sk.splash.data.models.UIPhoto
import com.sk.splash.ui.R
import com.sk.splash.ui.adapters.CollectionAdapter
import com.sk.splash.ui.adapters.PhotoAdapter
import com.sk.splash.ui.databinding.FragmentPhotosBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

abstract class PhotosFragment<B : ViewBinding> : BaseFragment<B>() {

    private var _itemsAdapter: PhotoAdapter? = null
    private val itemsAdapter get() = _itemsAdapter ?: throw IllegalStateException()

    abstract val listView: RecyclerView
    abstract val progressBar: ProgressBar

    abstract val items: Flow<PagingData<UIPhoto>>

    private fun onPhotoClicked(photo: UIPhoto) {
        val bundle = bundleOf("photoId" to photo.id)
        findNavController().navigate(R.id.action_home_to_photoDetails, bundle)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecyclerView()
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                items.onEach(itemsAdapter::submitData).launchIn(this)
                itemsAdapter.loadStateFlow.onEach(::updateLoadingState).launchIn(this)
            }
        }
    }

    private fun setupRecyclerView() {
        _itemsAdapter = PhotoAdapter(::onPhotoClicked)
        listView.apply {
            adapter = itemsAdapter
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }
    }

    private fun updateLoadingState(state: CombinedLoadStates) = with(binding) {
        progressBar.isVisible = state.refresh is LoadState.Loading
    }

    override fun onDestroyView() {
        _itemsAdapter = null
        super.onDestroyView()
    }
}