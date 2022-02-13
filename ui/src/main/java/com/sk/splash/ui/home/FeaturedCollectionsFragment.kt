package com.sk.splash.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import com.sk.splash.data.models.UICollection
import com.sk.splash.ui.fragments.CollectionsFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class FeaturedCollectionsFragment : CollectionsFragment() {

    override val items get() = viewModel.featuredCollections

    private val viewModel: HomeViewModel by viewModels({ requireParentFragment() })
}
