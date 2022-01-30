package com.sk.splash.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import com.sk.splash.data.models.UICollection
import com.sk.splash.ui.adapters.CollectionAdapter
import com.sk.splash.ui.databinding.FragmentCollectionsBinding

abstract class CollectionsFragment : BaseFragment<FragmentCollectionsBinding>() {

    override val bindingInflater: BindingProvider<FragmentCollectionsBinding>
        get() = FragmentCollectionsBinding::inflate

    lateinit var collectionAdapter: CollectionAdapter

    private fun onCollectionClicked(collection: UICollection) {
        TODO()
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        collectionAdapter = CollectionAdapter(::onCollectionClicked)
    }
}