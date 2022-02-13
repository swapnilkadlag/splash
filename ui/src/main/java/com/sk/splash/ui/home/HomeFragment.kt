package com.sk.splash.ui.home

import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayoutMediator
import com.sk.splash.ui.adapters.TabsAdapter
import com.sk.splash.ui.databinding.FragmentHomeBinding
import com.sk.splash.ui.fragments.BaseFragment
import com.sk.splash.ui.fragments.BindingProvider
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val bindingInflater: BindingProvider<FragmentHomeBinding>
        get() = FragmentHomeBinding::inflate

    private var mediator: TabLayoutMediator? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val homeTabsAdapter = TabsAdapter(this, 3) { position ->
            when (position) {
                0 -> LatestPhotosFragment()
                1 -> PopularPhotosFragment()
                2 -> FeaturedCollectionsFragment()
                else -> throw IllegalStateException()
            }
        }
        with(binding) {
            viewPager.adapter = homeTabsAdapter
            mediator = TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = when (position) {
                    0 -> "Latest"
                    1 -> "Popular"
                    2 -> "Featured"
                    else -> throw IllegalStateException()
                }
            }.also { it.attach() }
            viewPager.offscreenPageLimit = 2
        }
    }

    override fun onDestroyView() {
        mediator?.detach()
        mediator = null
        binding.viewPager.adapter = null
        super.onDestroyView()
    }
}