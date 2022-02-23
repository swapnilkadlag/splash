package com.sk.splash.ui.collectiondetails

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.sk.splash.ui.databinding.FragmentCollectionDetailsBinding
import com.sk.splash.ui.databinding.FragmentPhotoDetailsBinding
import com.sk.splash.ui.fragments.BaseFragment
import com.sk.splash.ui.fragments.BindingProvider
import com.sk.splash.ui.photodetails.PhotoDetailsFragmentArgs
import com.sk.splash.ui.photodetails.PhotoDetailsViewModel
import javax.inject.Inject

class CollectionDetailsFragment : BaseFragment<FragmentCollectionDetailsBinding>() {

    @Inject
    lateinit var viewModelAssistedFactory: CollectionDetailsViewModel.Factory

    private val args: CollectionDetailsFragmentArgs by navArgs()

    private val viewModel: PhotoDetailsViewModel by viewModels {
        CollectionDetailsViewModel.provideFactory(
            viewModelAssistedFactory,
            args.collectionId,
        )
    }

    override val bindingInflater: BindingProvider<FragmentCollectionDetailsBinding>
        get() = FragmentCollectionDetailsBinding::inflate


}