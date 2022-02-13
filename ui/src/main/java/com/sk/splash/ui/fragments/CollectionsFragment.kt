package com.sk.splash.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
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
import kotlinx.coroutines.launch

abstract class CollectionsFragment : BaseFragment<FragmentCollectionsBinding>() {

    override val bindingInflater: BindingProvider<FragmentCollectionsBinding>
        get() = FragmentCollectionsBinding::inflate

    private var _itemsAdapter: CollectionAdapter? = null
    private val itemsAdapter get() = _itemsAdapter ?: throw IllegalStateException()

    abstract val items: Flow<PagingData<UICollection>>

    private fun onCollectionClicked(collection: UICollection) {
        TODO()
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
        _itemsAdapter = CollectionAdapter(::onCollectionClicked)
        binding.rvCollections.apply {
            adapter = itemsAdapter
            layoutManager = LinearLayoutManager(context)
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