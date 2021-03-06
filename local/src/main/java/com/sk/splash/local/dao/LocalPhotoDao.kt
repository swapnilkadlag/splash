package com.sk.splash.local.dao

import androidx.paging.PagingSource
import androidx.room.*
import com.sk.splash.local.entities.LocalCollection
import com.sk.splash.local.entities.LocalPhoto
import kotlinx.coroutines.flow.Flow

@Dao
abstract class LocalPhotoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(photo: LocalPhoto)

    @Query("DELETE FROM photo WHERE photo.id = :id")
    abstract suspend fun delete(id: String)

    @Query("SELECT * FROM photo ORDER BY photo.savedAt DESC")
    abstract fun getAll(): PagingSource<Int, LocalPhoto>

    @Query("SELECT * FROM photo WHERE id = :id")
    abstract fun get(id: String): LocalPhoto?
}