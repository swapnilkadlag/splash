package com.sk.splash.ui.search

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.PagingData
import androidx.recyclerview.widget.RecyclerView
import com.sk.splash.data.models.UICollection
import com.sk.splash.data.models.UIPhoto
import com.sk.splash.ui.R
import com.sk.splash.ui.databinding.FragmentPhotosBinding
import com.sk.splash.ui.fragments.BindingProvider
import com.sk.splash.ui.fragments.CollectionsFragment
import com.sk.splash.ui.fragments.PhotosFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SearchedPhotosFragment : PhotosFragment<FragmentPhotosBinding>() {

    private val viewModel: SearchViewModel by viewModels({ requireParentFragment() })

    override val bindingInflater: BindingProvider<FragmentPhotosBinding>
        get() = FragmentPhotosBinding::inflate

    override val listView: RecyclerView
        get() = binding.rvPhotos

    override val progressBar: ProgressBar
        get() = binding.progressBar

    override val items: Flow<PagingData<UIPhoto>>
        get() = viewModel.searchedPhotos

    override val photoDetailsActionId: Int
        get() = R.id.action_search_to_photoDetails

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