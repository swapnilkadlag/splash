package com.sk.splash.ui.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabsAdapter(
    parentFragment: Fragment,
    private val count: Int,
    private val fragmentProvider: (Int) -> Fragment
) : FragmentStateAdapter(parentFragment) {

    override fun getItemCount(): Int = count

    override fun createFragment(position: Int) = fragmentProvider(position)
}