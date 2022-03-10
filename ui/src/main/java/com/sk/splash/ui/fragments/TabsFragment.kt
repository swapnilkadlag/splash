package com.sk.splash.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sk.splash.ui.adapters.TabsAdapter

abstract class TabsFragment<B : ViewBinding> : BaseFragment<B>() {
    private var mediator: TabLayoutMediator? = null

    abstract val viewPager: ViewPager2
    abstract val tabLayout: TabLayout

    abstract val tabsCount: Int

    abstract fun getTabFragment(position: Int): Fragment

    abstract fun getTabTitle(position: Int): String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tabsAdapter = TabsAdapter(this, tabsCount, ::getTabFragment)
        viewPager.adapter = tabsAdapter
        mediator = TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getTabTitle(position)
        }.also { it.attach() }
        viewPager.offscreenPageLimit = tabsCount - 1
    }

    override fun onDestroyView() {
        mediator?.detach()
        mediator = null
        viewPager.adapter = null
        super.onDestroyView()
    }
}