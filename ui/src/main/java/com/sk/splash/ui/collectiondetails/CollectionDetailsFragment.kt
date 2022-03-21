package com.sk.splash.ui.collectiondetails

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.paging.PagingData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.sk.splash.data.models.UICollectionDetails
import com.sk.splash.data.models.UIPhoto
import com.sk.splash.data.models.UIPhotoDetails
import com.sk.splash.ui.R
import com.sk.splash.ui.databinding.FragmentCollectionDetailsBinding
import com.sk.splash.ui.databinding.FragmentPhotoDetailsBinding
import com.sk.splash.ui.fragments.BaseFragment
import com.sk.splash.ui.fragments.BindingProvider
import com.sk.splash.ui.fragments.PhotosFragment
import com.sk.splash.ui.photodetails.PhotoDetailsFragmentArgs
import com.sk.splash.ui.photodetails.PhotoDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class CollectionDetailsFragment : PhotosFragment<FragmentCollectionDetailsBinding>() {

    @Inject
    lateinit var viewModelAssistedFactory: CollectionDetailsViewModel.Factory

    private val args: CollectionDetailsFragmentArgs by navArgs()

    private val viewModel: CollectionDetailsViewModel by viewModels {
        CollectionDetailsViewModel.provideFactory(
            viewModelAssistedFactory,
            args.collectionId,
        )
    }

    override val bindingInflater: BindingProvider<FragmentCollectionDetailsBinding>
        get() = FragmentCollectionDetailsBinding::inflate

    override val listView: RecyclerView
        get() = binding.rvPhotos

    override val progressBar: ProgressBar
        get() = binding.progressBar

    override val items: Flow<PagingData<UIPhoto>>
        get() = viewModel.collectionPhotos

    override val detailsActionId: Int
        get() = R.id.action_collectionDetails_to_photoDetails

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.collectionDetails.onEach(::updateUI).launchIn(lifecycleScope)
    }

    private fun updateUI(collectionDetails: UICollectionDetails?) = with(binding) {
        progressBar.isVisible = collectionDetails == null
        if (collectionDetails != null) {
            requireActivity().invalidateOptionsMenu()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.photo_details_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.favourite -> {
                viewModel.markFavorite()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        val favourite = menu.findItem(R.id.favourite)
        requireNotNull(favourite)
        viewModel.collectionDetails.value?.let {
            if (it.saved) {
                favourite.setIcon(R.drawable.ic_favorite)
            } else {
                favourite.setIcon(R.drawable.ic_favorite_outlined)
            }
        }
        super.onPrepareOptionsMenu(menu)
    }

}