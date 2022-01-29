package com.sk.splash.ui.common

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import com.sk.splash.data.utils.models.UICollection
import com.sk.splash.data.utils.models.UIPhoto
import com.sk.splash.ui.databinding.FragmentCollectionsBinding
import com.sk.splash.ui.databinding.FragmentPhotosBinding

abstract class CollectionsFragment : BaseFragment<FragmentCollectionsBinding>() {

    override val bindingInflater: BindingProvider<FragmentCollectionsBinding>
        get() = FragmentCollectionsBinding::inflate

    lateinit var collectionAdapter: CollectionAdapter

    private fun onPhotoClicked(photo: UICollection) {
        TODO()
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        collectionAdapter = CollectionAdapter(::onPhotoClicked)
    }
}