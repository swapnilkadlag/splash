package com.sk.splash.ui.adapters

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseListAdapter<VB : ViewBinding, VH : BaseListAdapter.BaseViewHolder<VB, T>, T : Any>(
    private val onItemClick: (T) -> Unit,
    diffUtil: DiffUtil.ItemCallback<T>
) : PagingDataAdapter<T, VH>(diffUtil) {

    override fun setStateRestorationPolicy(strategy: StateRestorationPolicy) {
        super.setStateRestorationPolicy(StateRestorationPolicy.PREVENT_WHEN_EMPTY)
    }

    abstract fun createViewHolder(parent: ViewGroup, onItemClick: (T) -> Unit): VH

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = getItem(position)
        item?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return createViewHolder(parent, onItemClick)
    }

    abstract class BaseViewHolder<VB : ViewBinding, T>(
        val binding: VB,
        val onItemClick: (T) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {
        abstract fun bind(item: T)
    }
}