package com.sk.splash.ui.favourites

import android.widget.ProgressBar
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.sk.splash.ui.R
import com.sk.splash.ui.databinding.FragmentPhotosBinding
import com.sk.splash.ui.fragments.BindingProvider
import com.sk.splash.ui.fragments.PhotosFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritePhotosFragment : PhotosFragment<FragmentPhotosBinding>() {

    override val items get() = viewModel.photos

    private val viewModel: FavoritesViewModel by viewModels({ requireParentFragment() })

    override val bindingInflater: BindingProvider<FragmentPhotosBinding>
        get() = FragmentPhotosBinding::inflate

    override val listView: RecyclerView
        get() = binding.rvPhotos

    override val progressBar: ProgressBar
        get() = binding.progressBar

    override val detailsActionId: Int
        get() = R.id.action_favorites_to_photoDetails
}