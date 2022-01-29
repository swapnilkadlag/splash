package com.sk.splash.ui.common

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import com.sk.splash.data.utils.models.UIPhoto
import com.sk.splash.ui.databinding.FragmentPhotosBinding

abstract class PhotosFragment : BaseFragment<FragmentPhotosBinding>() {

    override val bindingInflater: BindingProvider<FragmentPhotosBinding>
        get() = FragmentPhotosBinding::inflate

    lateinit var photoAdapter: PhotoAdapter

    private fun onPhotoClicked(photo: UIPhoto) {
        TODO()
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        photoAdapter = PhotoAdapter(::onPhotoClicked)
    }
}