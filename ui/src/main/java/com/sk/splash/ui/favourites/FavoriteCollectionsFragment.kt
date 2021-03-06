package com.sk.splash.ui.favourites

import android.widget.ProgressBar
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.sk.splash.ui.R
import com.sk.splash.ui.databinding.FragmentCollectionsBinding
import com.sk.splash.ui.databinding.FragmentPhotosBinding
import com.sk.splash.ui.fragments.BindingProvider
import com.sk.splash.ui.fragments.CollectionsFragment
import com.sk.splash.ui.fragments.PhotosFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteCollectionsFragment : CollectionsFragment<FragmentCollectionsBinding>() {

    override val items get() = viewModel.collections

    private val viewModel: FavoritesViewModel by viewModels({ requireParentFragment() })

    override val bindingInflater: BindingProvider<FragmentCollectionsBinding>
        get() = FragmentCollectionsBinding::inflate

    override val listView: RecyclerView
        get() = binding.rvCollections

    override val progressBar: ProgressBar
        get() = binding.progressBar

    override val detailsActionId: Int
        get() = R.id.action_favorites_to_collectionDetails
}