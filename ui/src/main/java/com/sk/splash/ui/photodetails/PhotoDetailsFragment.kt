package com.sk.splash.ui.photodetails

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.sk.splash.data.models.UIPhotoDetails
import com.sk.splash.ui.R
import com.sk.splash.ui.databinding.FragmentPhotoDetailsBinding
import com.sk.splash.ui.fragments.BaseFragment
import com.sk.splash.ui.fragments.BindingProvider
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class PhotoDetailsFragment : BaseFragment<FragmentPhotoDetailsBinding>() {

    @Inject
    lateinit var viewModelAssistedFactory: PhotoDetailsViewModel.Factory

    private val args: PhotoDetailsFragmentArgs by navArgs()

    private val viewModel: PhotoDetailsViewModel by viewModels {
        PhotoDetailsViewModel.provideFactory(
            viewModelAssistedFactory,
            args.photoId,
        )
    }

    override val bindingInflater: BindingProvider<FragmentPhotoDetailsBinding>
        get() = FragmentPhotoDetailsBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.photoDetails.onEach(::updateUI).launchIn(lifecycleScope)
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
        viewModel.photoDetails.value?.let {
            if (it.saved) {
                favourite.setIcon(R.drawable.ic_favorite)
            } else {
                favourite.setIcon(R.drawable.ic_favorite_outlined)
            }
        }
        super.onPrepareOptionsMenu(menu)
    }

    private fun updateUI(photoDetails: UIPhotoDetails?) = with(binding) {
        progressBar.isVisible = photoDetails == null
        llContent.isVisible = photoDetails != null

        if (photoDetails != null) {
            val aspect = photoDetails.height / photoDetails.width.toFloat()
            binding.ivPhoto.setAspectRatio(aspect)
            Glide
                .with(binding.root.context)
                .load(photoDetails.urls.regular)
                .placeholder(ColorDrawable(Color.parseColor(photoDetails.color)))
                .transition(DrawableTransitionOptions.withCrossFade(200))
                .into(ivPhoto)

            txtBio.isVisible = photoDetails.description.isNullOrEmpty().not()
            txtBio.text = photoDetails.description?.trim() ?: ""

            dateLayout.setValue(photoDetails.createdAt)
            likesLayout.setValue(photoDetails.likes.toString())
            resolutionLayout.setValue("${photoDetails.width} x ${photoDetails.height}")
            locationLayout.setValue(photoDetails.location.toString())

            requireActivity().invalidateOptionsMenu()
        }
    }
}