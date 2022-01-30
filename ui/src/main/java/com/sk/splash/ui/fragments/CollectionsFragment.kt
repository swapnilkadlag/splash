package com.sk.splash.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sk.splash.data.models.UICollection
import com.sk.splash.ui.adapters.CollectionAdapter
import com.sk.splash.ui.databinding.FragmentCollectionsBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

abstract class CollectionsFragment : BaseFragment<FragmentCollectionsBinding>() {

    override val bindingInflater: BindingProvider<FragmentCollectionsBinding>
        get() = FragmentCollectionsBinding::inflate

    lateinit var itemsAdapter: CollectionAdapter

    abstract val items: Flow<PagingData<UICollection>>

    private fun onCollectionClicked(collection: UICollection) {
        TODO()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        items.onEach(itemsAdapter::submitData).launchIn(lifecycleScope)
        itemsAdapter.loadStateFlow.onEach(::updateLoadingState).launchIn(lifecycleScope)
    }

    private fun setupRecyclerView() {
        itemsAdapter = CollectionAdapter(::onCollectionClicked)
        binding.rvCollections.apply {
            adapter = itemsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun updateLoadingState(state: CombinedLoadStates) = with(binding) {
        progressBar.isVisible = state.refresh is LoadState.Loading
    }
}