package com.sk.splash.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sk.splash.ui.fragments.PhotosFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class LatestPhotosFragment : PhotosFragment() {

    companion object {
        const val TAG = "latestPhotosFragment"
    }

    private val viewModel: HomeViewModel by viewModels({ requireParentFragment() })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        viewModel.latestPhotos()
            .onEach(photoAdapter::submitData)
            .launchIn(lifecycleScope)
        photoAdapter.loadStateFlow.onEach {
            binding.progressBar.isVisible = it.refresh is LoadState.Loading
        }.launchIn(lifecycleScope)
    }

    private fun setupRecyclerView() {
        binding.rvPhotos.apply {
            adapter = photoAdapter
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }
    }
}
