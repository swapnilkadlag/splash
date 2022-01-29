package com.sk.splash.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sk.splash.ui.common.BaseFragment
import com.sk.splash.ui.common.BindingProvider
import com.sk.splash.ui.common.PhotosFragment
import com.sk.splash.ui.common.RecyclerViewPager
import com.sk.splash.ui.databinding.FragmentPhotosBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class PopularPhotosFragment : PhotosFragment() {

    companion object {
        const val TAG = "popularPhotosFragment"
    }

    private val viewModel: HomeViewModel by viewModels({ requireParentFragment() })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        with(viewModel.popularPhotosLoader) {
            items.onEach { photoAdapter.submitList(it) }
                .launchIn(lifecycleScope)

            isLoading.onEach { binding.progressBar.isVisible = it }
                .launchIn(lifecycleScope)
        }
    }

    private fun setupRecyclerView() {
        binding.rvPhotos.apply {
            adapter = photoAdapter
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            RecyclerViewPager(
                recyclerView = this,
                isLastPage = { false },
                isLoading = { viewModel.popularPhotosLoader.isLoading.value },
                loadMore = { viewModel.popularPhotosLoader.loadNext() }
            )
        }
    }
}
