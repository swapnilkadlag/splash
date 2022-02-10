package com.sk.splash.remote.di

import android.content.Context
import com.chuckerteam.chucker.api.Chucker
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.sk.splash.remote.BuildConfig
import com.sk.splash.remote.adapters.DateTimeAdapter
import com.sk.splash.remote.utils.Constants.UNSPLASH_BASE_URL
import com.sk.splash.remote.service.RemoteService
import com.sk.splash.remote.service.RemoteServiceImpl
import com.sk.splash.remote.api.CollectionApi
import com.sk.splash.remote.api.PhotoApi
import com.sk.splash.remote.api.UserApi
import com.sk.splash.remote.utils.Constants
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.threeten.bp.format.DateTimeFormatter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    @Singleton
    fun provideDateTimeFormatter(): DateTimeFormatter {
        return DateTimeFormatter.ofPattern(Constants.DATE_TIME_FORMAT)
            .withLocale(Locale.getDefault())
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        @ApplicationContext context: Context,
        dateTimeFormatter: DateTimeFormatter
    ): Retrofit {
        val loggingInterceptor = HttpLoggingInterceptor().setLevel(
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BASIC
            else HttpLoggingInterceptor.Level.NONE
        )
        val chuckerInterceptor = ChuckerInterceptor.Builder(context).build()
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(chuckerInterceptor)
            .build()
        val moshi = Moshi.Builder()
            .add(DateTimeAdapter(dateTimeFormatter))
            .build()
        return Retrofit.Builder()
            .baseUrl(UNSPLASH_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun providePhotoApi(retrofit: Retrofit): PhotoApi {
        return retrofit.create(PhotoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCollectionApi(retrofit: Retrofit): CollectionApi {
        return retrofit.create(CollectionApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserApi(retrofit: Retrofit): UserApi {
        return retrofit.create(UserApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteService(
        photoApi: PhotoApi,
        collectionApi: CollectionApi,
        userApi: UserApi,
    ): RemoteService {
        return RemoteServiceImpl(photoApi, collectionApi, userApi)
    }
}