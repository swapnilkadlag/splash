package com.sk.splash.local.di

import android.content.Context
import com.sk.splash.local.db.LocalDatabase
import com.sk.splash.local.db.LocalDateTimeConverter
import com.sk.splash.local.service.LocalService
import com.sk.splash.local.service.LocalServiceImpl
import com.sk.splash.local.utils.Constants.DATE_TIME_FORMAT
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.threeten.bp.format.DateTimeFormatter
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context,
    ): LocalDatabase {
        val dateTimeConverter =
            LocalDateTimeConverter(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT))
        return LocalDatabase.getInstance(context, dateTimeConverter)
    }

    @Provides
    @Singleton
    fun provideRemoteService(
        photoApi: LocalDatabase,
    ): LocalService {
        return LocalServiceImpl(photoApi)
    }
}