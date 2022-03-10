package com.sk.splash.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.viewbinding.ViewBinding
import com.sk.splash.data.models.UIPhoto
import com.sk.splash.data.models.UIUser
import com.sk.splash.ui.adapters.PhotoAdapter
import com.sk.splash.ui.adapters.UserAdapter
import com.sk.splash.ui.databinding.FragmentUsersBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

abstract class UsersFragment<B : ViewBinding> : ListFragment<UIUser, B>() {

    private var _itemsAdapter: UserAdapter? = null
    val itemsAdapter get() = _itemsAdapter ?: throw IllegalStateException()

    private fun onUserClicked(user: UIUser) {
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecyclerView()
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                items.onEach(itemsAdapter::submitData).launchIn(this)
                itemsAdapter.loadStateFlow.onEach(::updateLoadingState).launchIn(this)
            }
        }
    }

    private fun setupRecyclerView() {
        _itemsAdapter = UserAdapter(::onUserClicked)
        listView.apply {
            adapter = itemsAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun updateLoadingState(state: CombinedLoadStates) {
        progressBar.isVisible = state.refresh is LoadState.Loading
    }

    override fun onDestroyView() {
        _itemsAdapter = null
        super.onDestroyView()
    }
}