package com.sk.splash.local.dao

import androidx.paging.PagingSource
import androidx.room.*
import com.sk.splash.local.entities.LocalUser

@Dao
abstract class LocalUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(user: LocalUser)

    @Query("DELETE FROM user WHERE user.username = :username")
    abstract suspend fun delete(username: String)

    @Query("SELECT * FROM user ORDER BY user.savedAt DESC")
    abstract fun getAll(): PagingSource<Int, LocalUser>

    @Query("SELECT * FROM user WHERE username = :username")
    abstract suspend fun get(username: String): LocalUser?
}