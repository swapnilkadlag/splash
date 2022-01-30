package com.sk.splash.ui.search

import com.sk.splash.ui.databinding.FragmentSearchBinding
import com.sk.splash.ui.fragments.BaseFragment
import com.sk.splash.ui.fragments.BindingProvider

class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override val bindingInflater: BindingProvider<FragmentSearchBinding>
        get() = FragmentSearchBinding::inflate
}