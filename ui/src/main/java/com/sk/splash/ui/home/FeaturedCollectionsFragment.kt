package com.sk.splash.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.sk.splash.ui.fragments.CollectionsFragment
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class FeaturedCollectionsFragment : CollectionsFragment() {

    companion object {
        const val TAG = "latestPhotosFragment"
    }

    private val viewModel: HomeViewModel by viewModels({ requireParentFragment() })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        viewModel.featuredCollections()
            .onEach(collectionAdapter::submitData)
            .launchIn(lifecycleScope)

        collectionAdapter.loadStateFlow.onEach {
            binding.progressBar.isVisible = it.refresh is LoadState.Loading
        }.launchIn(lifecycleScope)
    }

    private fun setupRecyclerView() {
        binding.rvCollections.apply {
            adapter = collectionAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}
