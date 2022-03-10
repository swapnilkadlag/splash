package com.sk.splash.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.annotation.CallSuper
import androidx.annotation.IdRes
import androidx.annotation.IntegerRes
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

abstract class PhotosFragment<B : ViewBinding> : ListFragment<UIPhoto, B>() {

    private var _itemsAdapter: PhotoAdapter? = null
    val itemsAdapter get() = _itemsAdapter ?: throw IllegalStateException()

    override fun onItemClick(item: UIPhoto) {
        val bundle = bundleOf("photoId" to item.id)
        findNavController().navigate(detailsActionId, bundle)
    }

    @CallSuper
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
        _itemsAdapter = PhotoAdapter(::onItemClick)
        listView.apply {
            adapter = itemsAdapter
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }
    }

    private fun updateLoadingState(state: CombinedLoadStates) {
        progressBar.isVisible = state.refresh is LoadState.Loading
    }

    override fun onDestroyView() {
        _itemsAdapter = null
        super.onDestroyView()
    }
}