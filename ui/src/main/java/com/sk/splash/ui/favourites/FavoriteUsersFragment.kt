package com.sk.splash.ui.favourites

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
import com.sk.splash.ui.search.SearchViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class FavoriteUsersFragment : UsersFragment<FragmentUsersBinding>() {

    private val viewModel: FavoritesViewModel by viewModels({ requireParentFragment() })

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
        get() = viewModel.users
}