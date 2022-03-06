package com.sk.splash.ui.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.PagingData
import com.sk.splash.data.models.UICollection
import com.sk.splash.ui.R
import com.sk.splash.ui.fragments.CollectionsFragment
import com.sk.splash.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchedCollectionsFragment : CollectionsFragment() {

    private val viewModel: SearchViewModel by viewModels({ requireParentFragment() })

    override val items: Flow<PagingData<UICollection>>
        get() = viewModel.searchedCollections

    override val collectionDetailsActionId: Int
        get() = R.id.action_search_to_collectionDetails

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.searchQuery
                    .distinctUntilChanged { old, new -> old == new }
                    .debounce(500)
                    .onEach { itemsAdapter.refresh() }
                    .launchIn(this)
            }
        }
    }
}