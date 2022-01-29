package com.sk.splash.ui.common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class PageLoader<T : Any>(
    private var pages: Int? = null,
    private var currentPage: Int = 1,
    private val scope: CoroutineScope,
    private val load: suspend (Int, (Int) -> Unit) -> List<T>,
) {
    private var _job: Job? = null

    private val _items: MutableStateFlow<List<T>> = MutableStateFlow(listOf())
    val items: StateFlow<List<T>> = _items.asStateFlow()

    private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private fun setPages(value: Int) {
        pages = value
    }

    fun loadNext() {
        if (pages != null && currentPage >= pages!!) return
        _job = scope.launch {
            _isLoading.value = true
            val response = load(currentPage, ::setPages)
            _items.value = _items.value + response
            currentPage++
            _isLoading.value = false
        }
    }

    fun refresh() {
        currentPage = 1
        pages = null
        _job?.cancel()
        loadNext()
    }
}