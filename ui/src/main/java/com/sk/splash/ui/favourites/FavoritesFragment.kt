package com.sk.splash.ui.favourites

import com.sk.splash.ui.common.BaseFragment
import com.sk.splash.ui.common.BindingProvider
import com.sk.splash.ui.databinding.FragmentFavoritesBinding

class FavoritesFragment : BaseFragment<FragmentFavoritesBinding>() {

    override val bindingInflater: BindingProvider<FragmentFavoritesBinding>
        get() = FragmentFavoritesBinding::inflate
}