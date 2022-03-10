package com.sk.splash.ui.search

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sk.splash.ui.adapters.TabsAdapter
import com.sk.splash.ui.databinding.FragmentSearchBinding
import com.sk.splash.ui.fragments.BaseFragment
import com.sk.splash.ui.fragments.BindingProvider
import com.sk.splash.ui.fragments.TabsFragment
import com.sk.splash.ui.home.FeaturedCollectionsFragment
import com.sk.splash.ui.home.LatestPhotosFragment
import com.sk.splash.ui.home.PopularPhotosFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : TabsFragment<FragmentSearchBinding>() {

    override val bindingInflater: BindingProvider<FragmentSearchBinding>
        get() = FragmentSearchBinding::inflate

    private val viewModel: SearchViewModel by viewModels()

    override val viewPager: ViewPager2
        get() = binding.viewPager

    override val tabLayout: TabLayout
        get() = binding.tabLayout

    override val tabsCount: Int
        get() = 3

    override fun getTabFragment(position: Int): Fragment {
        return when (position) {
            0 -> SearchedPhotosFragment()
            1 -> SearchedCollectionsFragment()
            2 -> SearchedUsersFragment()
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.txtSearchQuery.doAfterTextChanged {
            viewModel.updateSearchQuery(it.toString())
        }
    }
}