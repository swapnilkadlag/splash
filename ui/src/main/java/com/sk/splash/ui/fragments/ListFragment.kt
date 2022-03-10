package com.sk.splash.ui.fragments

import android.widget.ProgressBar
import androidx.annotation.IdRes
import androidx.paging.PagingData
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.sk.splash.data.models.UIPhoto
import kotlinx.coroutines.flow.Flow

abstract class ListFragment<L : Any, B : ViewBinding> : BaseFragment<B>() {

    @get:IdRes
    abstract val detailsActionId: Int

    abstract val listView: RecyclerView

    abstract val progressBar: ProgressBar

    abstract fun onItemClick(item: L)

    abstract val items: Flow<PagingData<L>>
}