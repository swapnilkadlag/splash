package com.sk.splash.data.paging

import android.util.Log
import androidx.paging.Pager

fun <V : Any> infinitePager(
    block: suspend (Int) -> List<V>
): Pager<Int, V> = Pager(
    config = defaultPagingConfig,
    pagingSourceFactory = { InfinitePagedSource(block) }
)

class InfinitePagedSource<V : Any>(
    private val block: suspend (Int) -> List<V>,
) : PagedSource<V>() {

    override fun getNextKey(currentPage: Int): Int {
        return currentPage + 1
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, V> {
        val page = params.key ?: 1
        return try {
            val response = block.invoke(page)
            LoadResult.Page(response, getPreviousKey(page), getNextKey(page))
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}

