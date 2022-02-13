package com.sk.splash.ui.home

import androidx.fragment.app.viewModels
import com.sk.splash.ui.fragments.PhotosFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularPhotosFragment : PhotosFragment() {

    override val items get() = viewModel.popularPhotos

    private val viewModel: HomeViewModel by viewModels({ requireParentFragment() })
}
