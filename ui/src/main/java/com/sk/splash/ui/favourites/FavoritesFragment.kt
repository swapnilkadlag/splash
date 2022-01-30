package com.sk.splash.ui.favourites

import com.sk.splash.ui.databinding.FragmentFavoritesBinding
import com.sk.splash.ui.fragments.BaseFragment
import com.sk.splash.ui.fragments.BindingProvider

class FavoritesFragment : BaseFragment<FragmentFavoritesBinding>() {

    override val bindingInflater: BindingProvider<FragmentFavoritesBinding>
        get() = FragmentFavoritesBinding::inflate
}