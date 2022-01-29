package com.sk.splash.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sk.splash.ui.common.*
import com.sk.splash.ui.databinding.FragmentFeaturedCollectionsBinding
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

        viewModel.featuredCollectionsLoader.items
            .onEach { collectionAdapter.submitList(it) }
            .launchIn(lifecycleScope)

        viewModel.featuredCollectionsLoader.isLoading
            .onEach { binding.progressBar.isVisible = it }
            .launchIn(lifecycleScope)
    }

    private fun setupRecyclerView() {
        binding.rvCollections.apply {
            adapter = collectionAdapter
            layoutManager = LinearLayoutManager(activity)
            RecyclerViewPager(
                recyclerView = this,
                isLastPage = { false },
                isLoading = { viewModel.featuredCollectionsLoader.isLoading.value },
                loadMore = { viewModel.featuredCollectionsLoader.loadNext() }
            )
        }
    }
}
