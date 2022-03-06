package com.sk.splash.ui.search

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.sk.splash.ui.adapters.TabsAdapter
import com.sk.splash.ui.databinding.FragmentSearchBinding
import com.sk.splash.ui.fragments.BaseFragment
import com.sk.splash.ui.fragments.BindingProvider
import com.sk.splash.ui.home.FeaturedCollectionsFragment
import com.sk.splash.ui.home.LatestPhotosFragment
import com.sk.splash.ui.home.PopularPhotosFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override val bindingInflater: BindingProvider<FragmentSearchBinding>
        get() = FragmentSearchBinding::inflate

    private val viewModel: SearchViewModel by viewModels()

    private var mediator: TabLayoutMediator? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val homeTabsAdapter = TabsAdapter(this, 3) { position ->
            when (position) {
                0 -> SearchedPhotosFragment()
                1 -> SearchedCollectionsFragment()
                2 -> SearchedUsersFragment()
                else -> throw IllegalStateException()
            }
        }
        with(binding) {
            viewPager.adapter = homeTabsAdapter
            mediator = TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = when (position) {
                    0 -> "Photos"
                    1 -> "Collections"
                    2 -> "Users"
                    else -> throw IllegalStateException()
                }
            }.also { it.attach() }
            viewPager.offscreenPageLimit = 1
        }

        binding.txtSearchQuery.doAfterTextChanged {
            viewModel.updateSearchQuery(it.toString())
        }
    }

    override fun onDestroyView() {
        mediator?.detach()
        mediator = null
        binding.viewPager.adapter = null
        super.onDestroyView()
    }
}