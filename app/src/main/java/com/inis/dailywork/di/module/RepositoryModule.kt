package com.inis.dailywork.di.module

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.inis.dailywork.data.local.AppPrefs
import com.inis.dailywork.data.local.PrefHelper
import com.inis.dailywork.data.local.room.AppDao
import com.inis.dailywork.data.local.room.AppDatabase
import com.inis.dailywork.data.repository.AppRepository
import com.inis.dailywork.data.repository.AppRepositoryImpl
import com.inis.dailywork.utils.Constants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideAppRepository(appRepositoryImpl: AppRepositoryImpl): AppRepository =
        appRepositoryImpl

    @Provides
    @Singleton
    fun providePrefsHelper(appPrefs: AppPrefs):PrefHelper = appPrefs

    @Provides
    @Singleton
    fun provideDatabaseName(): String = Constants.DATABASE_NAME

    @Provides
    @Singleton
    fun provideYogaDatabase(context: Context, databaseName: String) =
        Room.databaseBuilder(context, AppDatabase::class.java, databaseName).build()

    @Provides
    @Singleton
    fun provideYogaDAO(appDatabase: AppDatabase): AppDao = appDatabase.getDao()
}
