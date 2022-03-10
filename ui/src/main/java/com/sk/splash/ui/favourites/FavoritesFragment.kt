package com.sk.splash.ui.favourites

import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.sk.splash.ui.databinding.FragmentTabsBinding
import com.sk.splash.ui.fragments.BindingProvider
import com.sk.splash.ui.fragments.TabsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : TabsFragment<FragmentTabsBinding>() {

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
            0 -> FavoritePhotosFragment()
            1 -> FavoriteCollectionsFragment()
            2 -> FavoriteUsersFragment()
            else -> throw IllegalStateException()
        }
    }

    override fun getTabTitle(position: Int): String {
        return when (position) {
            0 -> "Photos"
            1 -> "Collections"
            2 -> "Users"
            else -> throw IllegalStateException()
        }
    }
}