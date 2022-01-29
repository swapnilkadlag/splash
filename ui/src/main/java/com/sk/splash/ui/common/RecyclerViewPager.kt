package com.sk.splash.ui.common

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class RecyclerViewPager(
    recyclerView: RecyclerView,
    private val isLastPage: () -> Boolean,
    private val loadMore: () -> Unit,
    private val isLoading: () -> Boolean,
    private val loadThreshold: Int = 4,
    private val startLoading: Boolean = true,
) : RecyclerView.OnScrollListener() {

    init {
        recyclerView.addOnScrollListener(this)
        if (startLoading) loadMore()
    }

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
        if (newState == RecyclerView.SCROLL_STATE_IDLE) {
            onScroll(recyclerView.layoutManager)
        }
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        onScroll(recyclerView.layoutManager)
    }

    private fun onScroll(layoutManager: RecyclerView.LayoutManager?) {
        if (layoutManager == null) return
        if (isLastPage() || isLoading()) return
        val lastVisibleItemIndex = getLastVisibleItemIndex(layoutManager)
        if (lastVisibleItemIndex + 1 >= layoutManager.itemCount - loadThreshold) {
            loadMore()
        }
    }

    private fun getLastVisibleItemIndex(layoutManager: RecyclerView.LayoutManager): Int {
        return when (layoutManager) {
            is LinearLayoutManager -> layoutManager.findLastVisibleItemPosition()
            is GridLayoutManager -> layoutManager.findLastVisibleItemPosition()
            is StaggeredGridLayoutManager ->
                layoutManager.findLastVisibleItemPositions(null).first()
            else -> 0
        }
    }
}
