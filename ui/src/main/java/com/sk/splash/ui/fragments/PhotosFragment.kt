package com.sk.splash.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import com.sk.splash.data.models.UIPhoto
import com.sk.splash.ui.adapters.PhotoAdapter
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