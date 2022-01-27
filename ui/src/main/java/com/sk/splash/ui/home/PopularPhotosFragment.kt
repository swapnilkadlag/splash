package com.sk.splash.ui.home

import com.sk.splash.ui.common.BaseFragment
import com.sk.splash.ui.common.BindingProvider
import com.sk.splash.ui.databinding.FragmentLatestPhotosBinding
import com.sk.splash.ui.databinding.FragmentPopularPhotosBinding

class PopularPhotosFragment : BaseFragment<FragmentPopularPhotosBinding>() {

    override val bindingInflater: BindingProvider<FragmentPopularPhotosBinding>
        get() = FragmentPopularPhotosBinding::inflate
}