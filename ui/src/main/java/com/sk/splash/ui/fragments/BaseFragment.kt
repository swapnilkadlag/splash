package com.sk.splash.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.lang.IllegalStateException

typealias BindingProvider<B> = (LayoutInflater, ViewGroup?, Boolean) -> B

abstract class BaseFragment<B : ViewBinding> : Fragment() {

    abstract val bindingInflater: BindingProvider<B>
    private var _binding: B? = null
    val binding: B get() = _binding ?: throw IllegalStateException()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = bindingInflater(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}