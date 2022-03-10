package com.sk.splash.data.paging

import androidx.paging.Pager
import androidx.paging.PagingSource

fun <V : Any> infinitePager(
    block: suspend (Int) -> List<V>
): Pager<Int, V> = Pager(
    config = defaultPagingConfig,
    pagingSourceFactory = { InfinitePagedSource(block) }
)

fun <V : Any> infiniteDbPager(
    pagingSourceProducer: () -> PagingSource<Int, V>,
): Pager<Int, V> = Pager(
    config = defaultPagingConfig,
    pagingSourceFactory = pagingSourceProducer
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

