package com.sk.splash.ui.common

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import com.sk.splash.data.utils.models.UIUser
import com.sk.splash.ui.databinding.FragmentUsersBinding

abstract class UsersFragment : BaseFragment<FragmentUsersBinding>() {

    override val bindingInflater: BindingProvider<FragmentUsersBinding>
        get() = FragmentUsersBinding::inflate

    lateinit var userAdapter: UserAdapter

    private fun onUserClicked(user: UIUser) {
        TODO()
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        userAdapter = UserAdapter(::onUserClicked)
    }
}