package com.sk.splash.ui.home

import androidx.fragment.app.viewModels
import com.sk.splash.ui.fragments.PhotosFragment

class PopularPhotosFragment : PhotosFragment() {

    override val items get() = viewModel.popularPhotos

    private val viewModel: HomeViewModel by viewModels({ requireParentFragment() })
}
