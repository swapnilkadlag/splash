package com.sk.splash.ui.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.sk.splash.ui.databinding.FragmentTabsBinding
import com.sk.splash.ui.fragments.BindingProvider
import com.sk.splash.ui.fragments.TabsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : TabsFragment<FragmentTabsBinding>() {

    override val bindingInflater: BindingProvider<FragmentTabsBinding>
        get() = FragmentTabsBinding::inflate

    override val viewPager: ViewPager2
        get() = binding.viewPager

    override val tabLayout: TabLayout
        get() = binding.tabLayout

    override val tabsCount: Int
        get() = 3

    override fun getTabFragment(position: Int): Fragment {
        return when (position) {
            0 -> LatestPhotosFragment()
            1 -> PopularPhotosFragment()
            2 -> FeaturedCollectionsFragment()
            else -> throw IllegalStateException()
        }
    }

    override fun getTabTitle(position: Int): String {
        return when (position) {
            0 -> "Latest"
            1 -> "Popular"
            2 -> "Featured"
            else -> throw IllegalStateException()
        }
    }
}