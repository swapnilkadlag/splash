package com.sk.splash.ui.collectiondetails

import android.widget.ProgressBar
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.paging.PagingData
import androidx.recyclerview.widget.RecyclerView
import com.sk.splash.data.models.UIPhoto
import com.sk.splash.ui.databinding.FragmentCollectionDetailsBinding
import com.sk.splash.ui.databinding.FragmentPhotoDetailsBinding
import com.sk.splash.ui.fragments.BaseFragment
import com.sk.splash.ui.fragments.BindingProvider
import com.sk.splash.ui.fragments.PhotosFragment
import com.sk.splash.ui.photodetails.PhotoDetailsFragmentArgs
import com.sk.splash.ui.photodetails.PhotoDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
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
}