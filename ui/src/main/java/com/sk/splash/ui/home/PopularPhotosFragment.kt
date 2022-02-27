package com.sk.splash.ui.home

import android.widget.ProgressBar
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.sk.splash.ui.databinding.FragmentPhotosBinding
import com.sk.splash.ui.fragments.BindingProvider
import com.sk.splash.ui.fragments.PhotosFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularPhotosFragment : PhotosFragment<FragmentPhotosBinding>() {

    override val items get() = viewModel.popularPhotos

    private val viewModel: HomeViewModel by viewModels({ requireParentFragment() })

    override val bindingInflater: BindingProvider<FragmentPhotosBinding>
        get() = FragmentPhotosBinding::inflate

    override val listView: RecyclerView
        get() = binding.rvPhotos

    override val progressBar: ProgressBar
        get() = binding.progressBar
}
