package com.sk.splash.ui.home

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.sk.splash.ui.R
import com.sk.splash.ui.databinding.FragmentPhotosBinding
import com.sk.splash.ui.fragments.BindingProvider
import com.sk.splash.ui.fragments.PhotosFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LatestPhotosFragment : PhotosFragment<FragmentPhotosBinding>() {

    override val items get() = viewModel.latestPhotos

    private val viewModel: HomeViewModel by viewModels({ requireParentFragment() })

    override val bindingInflater: BindingProvider<FragmentPhotosBinding>
        get() = FragmentPhotosBinding::inflate

    override val listView: RecyclerView
        get() = binding.rvPhotos

    override val progressBar: ProgressBar
        get() = binding.progressBar

    override val detailsActionId: Int
        get() = R.id.action_home_to_photoDetails
}
