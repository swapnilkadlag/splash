package com.sk.splash.ui.home

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sk.splash.data.models.UICollection
import com.sk.splash.ui.R
import com.sk.splash.ui.databinding.FragmentCollectionsBinding
import com.sk.splash.ui.fragments.BindingProvider
import com.sk.splash.ui.fragments.CollectionsFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class FeaturedCollectionsFragment : CollectionsFragment<FragmentCollectionsBinding>() {

    override val items get() = viewModel.featuredCollections

    private val viewModel: HomeViewModel by viewModels({ requireParentFragment() })

    override val detailsActionId: Int
        get() = R.id.action_home_to_collectionDetails

    override val bindingInflater: BindingProvider<FragmentCollectionsBinding>
        get() = FragmentCollectionsBinding::inflate

    override val listView: RecyclerView
        get() = binding.rvCollections

    override val progressBar: ProgressBar
        get() = binding.progressBar
}
