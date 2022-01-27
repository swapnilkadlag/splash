package com.sk.splash.ui.home

import com.sk.splash.ui.common.BaseFragment
import com.sk.splash.ui.common.BindingProvider
import com.sk.splash.ui.databinding.FragmentFeaturedCollectionsBinding

class FeaturedCollectionsFragment : BaseFragment<FragmentFeaturedCollectionsBinding>() {

    override val bindingInflater: BindingProvider<FragmentFeaturedCollectionsBinding>
        get() = FragmentFeaturedCollectionsBinding::inflate
}