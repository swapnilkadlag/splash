package com.sk.splash.local.dao

import androidx.paging.PagingSource
import androidx.room.*
import com.sk.splash.local.entities.*
import kotlinx.coroutines.flow.Flow

@Dao
abstract class LocalCollectionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(collection: LocalCollection)

    @Query("DELETE FROM collection WHERE collection.id = :id")
    abstract suspend fun delete(id: String)

    @Query("SELECT * FROM collection ORDER BY collection.savedAt DESC")
    abstract fun getAll(): PagingSource<Int, LocalCollection>

    @Query("SELECT * FROM collection WHERE id = :id")
    abstract fun get(id: String): LocalCollection?
}