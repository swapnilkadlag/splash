package com.sk.splash.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.sk.splash.local.dao.LocalCollectionDao
import com.sk.splash.local.dao.LocalPhotoDao
import com.sk.splash.local.dao.LocalUserDao
import com.sk.splash.local.entities.LocalCollection
import com.sk.splash.local.entities.LocalPhoto
import com.sk.splash.local.entities.LocalUser
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Database(
    entities = [
        LocalPhoto::class,
        LocalCollection::class,
        LocalUser::class,
    ],
    version = 1,
    exportSchema = false,
)
@TypeConverters(LocalDateTimeConverter::class)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun userDao(): LocalUserDao
    abstract fun collectionDao(): LocalCollectionDao
    abstract fun photoDao(): LocalPhotoDao

    companion object {
        @Volatile
        private var instance: LocalDatabase? = null

        fun getInstance(
            context: Context,
            dateTimeConverter: LocalDateTimeConverter,
        ): LocalDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(
                    context,
                    dateTimeConverter,
                ).also { newInstance -> instance = newInstance }
            }
        }

        private fun buildDatabase(
            context: Context,
            dateTimeConverter: LocalDateTimeConverter,
        ): LocalDatabase {
            return Room.databaseBuilder(context, LocalDatabase::class.java, "local_database")
                .addTypeConverter(dateTimeConverter)
                .build()
        }
    }
}