package com.sk.splash.ui.search

import com.sk.splash.ui.common.BaseFragment
import com.sk.splash.ui.common.BindingProvider
import com.sk.splash.ui.databinding.FragmentSearchBinding

class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override val bindingInflater: BindingProvider<FragmentSearchBinding>
        get() = FragmentSearchBinding::inflate
}