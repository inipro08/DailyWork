package com.inis.famo.di.module

import com.google.gson.Gson
import com.inis.famo.data.local.AppPrefs
import com.inis.famo.data.local.PrefHelper
import com.inis.famo.data.repository.AppRepository
import com.inis.famo.data.repository.AppRepositoryImpl
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
}
