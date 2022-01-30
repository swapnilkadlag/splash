package com.sk.splash.ui.home

import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayoutMediator
import com.sk.splash.ui.adapters.TabsAdapter
import com.sk.splash.ui.databinding.FragmentHomeBinding
import com.sk.splash.ui.fragments.BaseFragment
import com.sk.splash.ui.fragments.BindingProvider

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val bindingInflater: BindingProvider<FragmentHomeBinding>
        get() = FragmentHomeBinding::inflate

    private lateinit var homeTabsAdapter: TabsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        homeTabsAdapter = TabsAdapter(this, 3) { position ->
            when (position) {
                0 -> LatestPhotosFragment()
                1 -> PopularPhotosFragment()
                2 -> FeaturedCollectionsFragment()
                else -> throw IllegalStateException()
            }
        }
        with(binding) {
            viewPager.adapter = homeTabsAdapter
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = when (position) {
                    0 -> "Latest"
                    1 -> "Popular"
                    2 -> "Featured"
                    else -> throw IllegalStateException()
                }
            }.attach()
        }
    }
}