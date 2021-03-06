package com.sk.splash.ui.search

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.PagingData
import androidx.recyclerview.widget.RecyclerView
import com.sk.splash.data.models.UIUser
import com.sk.splash.ui.databinding.FragmentUsersBinding
import com.sk.splash.ui.fragments.BindingProvider
import com.sk.splash.ui.fragments.UsersFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchedUsersFragment : UsersFragment<FragmentUsersBinding>() {

    private val viewModel: SearchViewModel by viewModels({ requireParentFragment() })

    override val bindingInflater: BindingProvider<FragmentUsersBinding>
        get() = FragmentUsersBinding::inflate

    override val detailsActionId: Int
        get() = TODO("Not yet implemented")

    override val listView: RecyclerView
        get() = binding.rvUsers

    override val progressBar: ProgressBar
        get() = binding.progressBar

    override fun onItemClick(item: UIUser) {
        TODO("Not yet implemented")
    }

    override val items: Flow<PagingData<UIUser>>
        get() = viewModel.searchedUsers

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.searchQuery
                    .distinctUntilChanged { old, new -> old == new }
                    .debounce(500)
                    .onEach { itemsAdapter.refresh() }
                    .launchIn(this)
            }
        }
    }
}