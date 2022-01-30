package com.sk.splash.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sk.splash.data.models.UIPhoto
import com.sk.splash.ui.adapters.PhotoAdapter
import com.sk.splash.ui.databinding.FragmentPhotosBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

abstract class PhotosFragment : BaseFragment<FragmentPhotosBinding>() {

    override val bindingInflater: BindingProvider<FragmentPhotosBinding>
        get() = FragmentPhotosBinding::inflate

    lateinit var itemAdapter: PhotoAdapter

    abstract val items: Flow<PagingData<UIPhoto>>

    private fun onPhotoClicked(photo: UIPhoto) {
        TODO()
    }

    private fun setupRecyclerView() {
        itemAdapter = PhotoAdapter(::onPhotoClicked)
        binding.rvPhotos.apply {
            adapter = itemAdapter
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        items.onEach(itemAdapter::submitData).launchIn(lifecycleScope)
        itemAdapter.loadStateFlow.onEach(::updateLoadingState).launchIn(lifecycleScope)
    }

    private fun updateLoadingState(state: CombinedLoadStates) = with(binding) {
        progressBar.isVisible = state.refresh is LoadState.Loading
    }
}