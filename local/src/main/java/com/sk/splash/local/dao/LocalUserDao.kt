package com.sk.splash.local.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.sk.splash.local.entities.LocalCollection
import com.sk.splash.local.entities.LocalUser
import kotlinx.coroutines.flow.Flow

@Dao
abstract class LocalUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(user: LocalUser)

    @Query("DELETE FROM user WHERE user.username = :username")
    abstract suspend fun delete(username: String)

    @Query("SELECT * FROM user ORDER BY user.savedAt DESC")
    abstract fun getAll(): Flow<List<LocalUser>>
}