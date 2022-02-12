package com.sk.splash.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import com.sk.splash.data.models.UIUser
import com.sk.splash.ui.adapters.PhotoAdapter
import com.sk.splash.ui.adapters.UserAdapter
import com.sk.splash.ui.databinding.FragmentUsersBinding

abstract class UsersFragment : BaseFragment<FragmentUsersBinding>() {

    override val bindingInflater: BindingProvider<FragmentUsersBinding>
        get() = FragmentUsersBinding::inflate

    private var _itemsAdapter: UserAdapter? = null
    private val itemsAdapter get() = _itemsAdapter ?: throw IllegalStateException()

    private fun onUserClicked(user: UIUser) {
        TODO()
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _itemsAdapter = UserAdapter(::onUserClicked)
    }

    override fun onDestroy() {
        _itemsAdapter = null
        super.onDestroy()
    }

    override fun onDestroyView() {
        _itemsAdapter = null
        super.onDestroyView()
    }
}