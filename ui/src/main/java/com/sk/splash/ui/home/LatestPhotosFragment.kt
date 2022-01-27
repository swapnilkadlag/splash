package com.sk.splash.ui.home

import com.sk.splash.ui.common.BaseFragment
import com.sk.splash.ui.common.BindingProvider
import com.sk.splash.ui.databinding.FragmentFeaturedCollectionsBinding
import com.sk.splash.ui.databinding.FragmentLatestPhotosBinding

class LatestPhotosFragment : BaseFragment<FragmentLatestPhotosBinding>() {

    override val bindingInflater: BindingProvider<FragmentLatestPhotosBinding>
        get() = FragmentLatestPhotosBinding::inflate
}