package com.sk.splash.data.paging

import androidx.paging.Pager

data class FinitePageData<T>(
    val items: List<T>,
    val totalPages: Int,
) {
    companion object {
        fun <T> empty() = FinitePageData<T>(listOf(), 0)
    }
}

fun <V : Any> finitePager(
    totalPages: Int = 1,
    block: suspend (Int) -> FinitePageData<V>
): Pager<Int, V> = Pager(
    config = defaultPagingConfig,
    pagingSourceFactory = { FinitePagedSource(totalPages, block) }
)

class FinitePagedSource<V : Any>(
    private var totalPages: Int,
    private val block: suspend (Int) -> FinitePageData<V>,
) : PagedSource<V>() {

    override fun getNextKey(currentPage: Int): Int? {
        return if (currentPage < totalPages) return currentPage + 1
        else null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, V> {
        val page = params.key ?: 1
        return try {
            val response = block.invoke(page)
            totalPages = response.totalPages
            LoadResult.Page(response.items, getPreviousKey(page), getNextKey(page))
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
